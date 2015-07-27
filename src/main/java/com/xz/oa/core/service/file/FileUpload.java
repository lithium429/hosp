/**   
 * @Title: FileUpload.java 
 * @Package: com.xz.base.utils 
 * @Description: 文件上传
 * @author: davidwan
 * @date: 2014-7-22 下午4:41:01 
 * @version: V1.0   
 */
package com.xz.oa.core.service.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xz.base.model.JsonResult;
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.LogHelper;
import com.xz.base.utils.RandomUtil;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

public class FileUpload {
	public static final String UPLOAD_DIR = "uploadDir";
	public static final String UPLOAD_IMAGE_EXT = "uploadImageExt";
	public static final String UPLOAD_FLASH_EXT = "uploadFlashExt";
	public static final String UPLOAD_MEDIA_EXT = "uploadMediaExt";
	public static final String UPLOAD_FILE_EXT = "uploadFileExt";
	public static final String UPLOAD_DOC_EXT = "uploadDocExt";
	public static final String UPLAOD_MAX_SIZE = "uplaodMaxSize";
	public static final String BATCH_UPLOAD_LIMIT = "batchUploadLimit";

	/**
	 * Servlet请求
	 */
	private HttpServletRequest request;

	/**
	 * 实际路径
	 */
	private String savePath;

	/**
	 * 保存的相当路径
	 */
	private String saveUrl;

	/**
	 * 单个文件最大
	 */
	private long maxSize;

	/**
	 * 扩展名Map
	 */
	private Map<String, String> extMap;

	public FileUpload() {

	}

	public FileUpload(HttpServletRequest request) {
		this.request = request;
		String uploadDir = ConfigValue.readValue(UPLOAD_DIR, "/upload/");
		this.savePath = request.getServletContext().getRealPath("") + uploadDir;
		this.saveUrl = request.getContextPath() + uploadDir;

		maxSize = ConfigValue.readLongValue(UPLAOD_MAX_SIZE, 20) * 1024 * 1024;

		// 定义允许上传的文件扩展名
		extMap = new HashMap<String, String>();
		extMap.put("image", ConfigValue.readValue(UPLOAD_IMAGE_EXT, "gif,jpg,jpeg,png,bmp"));
		extMap.put("flash", ConfigValue.readValue(UPLOAD_FLASH_EXT, "swf,flv"));
		extMap.put("media", ConfigValue.readValue(UPLOAD_MEDIA_EXT, "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb"));
		extMap.put("file", ConfigValue.readValue(UPLOAD_FILE_EXT, "gif,jpg,jpeg,png,bmp,swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2"));
	}

	public FileUpload(HttpServletRequest request, boolean isOther) {
		this.request = request;
		String uploadDir = ConfigValue.readValue(UPLOAD_DIR, "/upload/");
		this.savePath = request.getServletContext().getRealPath("") + uploadDir;
		this.saveUrl = request.getContextPath() + uploadDir;

		maxSize = ConfigValue.readLongValue(UPLAOD_MAX_SIZE, 2) * 1024 * 1024;
	}

	public Object process() {
		try {
			if (!ServletFileUpload.isMultipartContent(request)) {
				return new JsonResult(false, "请选择文件！");
			}
			// 检查目录
			File uploadDir = new File(savePath);
			if (!uploadDir.isDirectory()) {
				boolean flag = uploadDir.mkdir();
				if (!flag) {
					return new JsonResult(false, "创建文件夹时出错！");
				}
				uploadDir.setWritable(true);
				uploadDir.setReadable(true);
			}

			// 检查目录写权限
			if (!uploadDir.canWrite()) {
				return new JsonResult(false, "上传目录没有写权限！");
			}

			String dirName = request.getParameter("dir");
			if (dirName == null) {
				dirName = "file";
			}
			if (!extMap.containsKey(dirName)) {
				return new JsonResult(false, "目录名不正确！");
			}
			// 创建文件夹
			savePath += dirName + "/";
			saveUrl += dirName + "/";
			File saveDirFile = new File(savePath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String ymd = sdf.format(new Date());
			savePath += ymd + "/";
			saveUrl += ymd + "/";
			File dirFile = new File(savePath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iterator = items.iterator();

			Integer moduleType = null, directoryId = null, fileId = null;
			String fileName = "", fileExt = "", itemText = "", info = "";

			FileItem item = null;
			while (iterator.hasNext()) {
				item = (FileItem) iterator.next();
				if (item.isFormField()) {
					itemText = item.getString("utf-8").trim();
					if (item.getFieldName().equalsIgnoreCase("moduleType")) {
						moduleType = NumberUtils.toInt(itemText, 0);
					} else if (item.getFieldName().equalsIgnoreCase("directoryId")) {
						directoryId = NumberUtils.toInt(itemText, 0);
					} else if (item.getFieldName().equalsIgnoreCase("fileType")) {
						fileExt = itemText;
					} else if (item.getFieldName().equalsIgnoreCase("fileId")) {
						fileId = NumberUtils.toInt(itemText, 0);
					} else if (item.getFieldName().equalsIgnoreCase("info")) {
						info = itemText;
					}
				} else {
					// 检查文件大小
					if (item.getSize() > maxSize) {
						return new JsonResult(false, "上传文件大小超过限制！");
					}
					fileName = item.getName();
					if (StringUtils.isBlank(fileExt)) {
						fileExt = fileName.substring(fileName.lastIndexOf('.') + 1);
					}

					if (fileName.lastIndexOf(".") < 0) {
						fileName = fileName + "." + fileExt;
					}
					sdf = new SimpleDateFormat("HHmmssSSS");
					String newFileName = RandomUtil.generateString(32) + sdf.format(new Date()) + "." + fileExt;
					File uploadedFile = new File(savePath, newFileName);
					item.write(uploadedFile);
					saveUrl = saveUrl + newFileName;

					// 保存文件到数据库
					if (moduleType != 0 && directoryId != 0) {
						try {
							ApplicationContext theContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
							FileService fileService = (FileService) theContext.getBean("fileService");
							SystemLogService systemLogService = (SystemLogService) theContext.getBean("systemLogService");
							com.xz.oa.core.domain.entity.File entity = null;
							if (fileId == null || fileId == 0) {
								entity = new com.xz.oa.core.domain.entity.File(uploadedFile, fileName, moduleType, saveUrl, directoryId);
								if (StringUtils.isNotBlank(info)) {
									entity.setInfo(info);
								}
								fileService.create(entity);
								// 添加操作日志
								systemLogService.create(EnumLogModule.我的文档.getValue(), "添加我的文档", "添加我的文档：" + fileName);
							} else {
								entity = new com.xz.oa.core.domain.entity.File(fileId, saveUrl);
								fileService.modify(entity);
								// 添加操作日志
								systemLogService.create(EnumLogModule.我的文档.getValue(), "修改我的文档", "修改我的文档ID：" + fileId);
							}
						} catch (Exception ex) {
							LogHelper.getLogger().error("保存文件到数据库时失败", ex);
						}
					}
				}
			}
			return new JsonResult(true, null, saveUrl);
		} catch (Exception ex) {
			LogHelper.getLogger().error("上传文件时出错", ex);
			return new JsonResult(false, "上传文件过程中出错！");
		}
	}

	public Object processOther() {
		try {

			// 创建文件夹
			savePath += "image/";
			saveUrl += "image/";
			File saveDirFile = new File(savePath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String ymd = sdf.format(new Date());
			savePath += ymd + "/";
			saveUrl += ymd + "/";
			File dirFile = new File(savePath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}

			sdf = new SimpleDateFormat("HHmmssSSS");
			String fileName = RandomUtil.generateString(32) + sdf.format(new Date()) + ".jpg";
			savePath = savePath + fileName;
			saveUrl = saveUrl + fileName;

			File file = new File(savePath);
			ImageInputStream stream = ImageIO.createImageInputStream(request.getInputStream());

			if (stream.length() > maxSize) {
				return new JsonResult(false, "上传文件大小超过限制！");
			}

			BufferedImage bufferedImage = ImageIO.read(stream);
			if (!file.exists()) {
				file.createNewFile();
			}
			// 将BufferedImage变量写入文件中。
			ImageIO.write(bufferedImage, "jpg", file);

			return new JsonResult(true, null, savePath + "|" + saveUrl);
		} catch (Exception ex) {
			LogHelper.getLogger().error("上传文件时出错", ex);
			return new JsonResult(false, "上传文件过程中出错！");
		}
	}
}
