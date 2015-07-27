package com.xz.oa.core.service.file;

import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.dao.file.FileDao;
import com.xz.oa.core.dao.file.FileUserDao;
import com.xz.oa.core.domain.entity.File;
import com.xz.oa.core.domain.entity.FileUser;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service("fileService")
public class FileService {

	@Resource
	private FileDao fileDao;

	@Resource
	private FileUserDao fileUserDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return File
	 * @author davidwan
	 */
	public File findById(Integer id) {
		File entity = new File(id);
		return fileDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return File
	 * @author davidwan
	 */
	public File findWithUsersById(Integer id) {
		File entity = new File(id);
		return fileDao.selectEntity(entity, "Users");
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return File
	 * @author davidwan
	 */
	public File find(File entity) {
		return fileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<File>
	 * @author davidwan
	 */
	public List<File> queryList(File entity) {
		return fileDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<File>
	 * @author davidwan
	 */
	public PageInfo<File> queryPageList(File entity, int pageIndex, int pageSize) {
		return fileDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<File>
	 * @author davidwan
	 */
	public PageInfo<File> querySummaryPageList(File entity, int pageIndex, int pageSize) {
		return fileDao.selectEntityPageList(entity, "Summary", pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(File entity) {
		// 获取并设置创建用户id
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipal();
		entity.setCreator_id(shiroUser.getId());

		// 若要获取id，请使用entity.getId();
		int result = fileDao.insertEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 修改
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modify(File entity) {
		int result = fileDao.updateEntity(entity);
		if (result > 0) {
			if(entity.getIs_delete()!=null && entity.getIs_delete())
			{
				//添加操作日志
				systemLogService.create(EnumLogModule.我的文档.getValue(), "删除文件","删除文件ID：" + (
						entity.getId()==null?StringUtil.buildIds((String[])entity.getMap().get("ids")):entity.getId()));
			}else
			{
				//添加操作日志
				systemLogService.create(EnumLogModule.我的文档.getValue(), "修改文件名","修改文件名：" + entity.getName());
			}
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 批量恢复
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modifyRecover(File entity) {
		int result = fileDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的文档.getValue(), "批量恢复除文件","批量恢复文件ID：" + StringUtil.buildIds((String[])entity.getMap().get("ids")));
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 保存文件可见范围
	 * @param fileId
	 * @param userIds
	 * @return JsonResult
	 */
	public JsonResult modifyForFileUser(Integer fileId, String userIds) {
		// 先删除已有的可见用户
		FileUser entity = new FileUser(fileId);
		fileUserDao.deleteEntity(entity); 
		
		List<Integer> idList = StringUtil.convertToList(userIds);
		if (idList != null) {
			for (Integer userId : idList) {
				entity = new FileUser(fileId, userId);
				fileUserDao.insertEntity(entity);
			}
		}
		//添加操作日志
		systemLogService.create(EnumLogModule.总结文档.getValue(), "文件可见用户","文件可见用户ID：" + fileId);
		return new JsonResult(true);
	}
	
 
	/**
	 * @Description  批量保存文件可见范围
	 * @param fileIds
	 * @param userIds
	 * @return JsonResult     
	 */
	public JsonResult modifyForFileUser(String fileIds, String userIds) {
		List<Integer> fileIdList = StringUtil.convertToList(fileIds);	
		List<Integer> userIdList = StringUtil.convertToList(userIds);
		if (userIdList != null && fileIdList != null) {
			// 先删除已有的可见用户			
			FileUser entity = new FileUser();
			entity.getMap().put("file_ids", fileIdList);
			fileUserDao.deleteEntity(entity); 
			
			for(Integer fileId: fileIdList){
				for (Integer userId : userIdList) {
					entity = new FileUser(fileId, userId);
					fileUserDao.insertEntity(entity);
				}
			}
		}

		//添加操作日志
		systemLogService.create(EnumLogModule.总结文档.getValue(), "文件批量可见用户","文件批量可见用户ID：" + fileIds);
		return new JsonResult(true);
	}

	/**
	 * @Description 根据Id删除
	 * @param id
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult removeById(Integer id) {
		File entity = new File();
		entity.setId(id);
		int result = fileDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.文档回收站.getValue(), "物理删除文件","物理删除文件ID：" + id);
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据多个Id删除
	 * @param ids
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult removeByIds(String ids) {
		File entity = new File();
		entity.getMap().put("ids", ids.split(","));
		int result = fileDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.文档回收站.getValue(), "批量物理删除文件","批量物理删除文件ID：" + ids);
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据指定条件删除
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult remove(File entity) {
		int result = fileDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
