package com.xz.oa.core.service.file;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.model.ZTreeNode;
import com.xz.oa.core.dao.file.DirectoryDao;
import com.xz.oa.core.dao.file.DirectoryDeptDao;
import com.xz.oa.core.dao.file.FileDao;
import com.xz.oa.core.domain.entity.Directory;
import com.xz.oa.core.domain.entity.DirectoryDept;
import com.xz.oa.core.domain.enums.EnumDirModuleType;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class DirectoryService {

	@Resource
	private DirectoryDao directoryDao;

	@Resource
	private DirectoryDeptDao directoryDeptDao;

	@Resource
	private FileDao fileDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Directory
	 * @author davidwan
	 */
	public Directory findById(Integer id) {
		Directory entity = new Directory();
		entity.setId(id);
		return directoryDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Directory
	 * @author davidwan
	 */
	public Directory find(Directory entity) {
		return directoryDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Directory>
	 * @author davidwan
	 */
	public List<Directory> queryList(Directory entity) {
		return directoryDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Directory>
	 * @author davidwan
	 */
	public PageInfo<Directory> queryPageList(Directory entity, int pageIndex, int pageSize) {
		return directoryDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 获取用户文件夹
	 * @param userId
	 * @param parentId
	 * @param moduleType
	 * @return List<ZTreeNode>
	 */
	public List<ZTreeNode> queryAsyncTreeList(Integer userId, Integer parentId, Integer moduleType) {
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();

		Directory entity = new Directory(); 
		entity.setModule_type(moduleType); 
		
		if (moduleType == EnumDirModuleType.我的文档.getValue()) {
			entity.setCreator_id(userId);
		}
		if (parentId == 0) {
			entity.setLayer(1);
		} else {
			entity.setParent_id(parentId);
		}
		List<Directory> directoryList = directoryDao.selectEntityList(entity);
		if (directoryList != null && directoryList.size() > 0) {
			ZTreeNode nodeItem = null;
			for (Directory directory : directoryList) {
				nodeItem = directory.buildAsyncTreeNode(parentId);
				treeList.add(nodeItem);
			}
		}
		return treeList;
	}
	
	/**
	 * @Description 获取用户文件夹
	 * @param userId
	 * @param parentId
	 * @param moduleType
	 * @return List<ZTreeNode>
	 */
	public List<ZTreeNode> queryTreeList(Integer userId, Integer moduleType) {
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();

		Directory entity = new Directory(); 
		entity.setModule_type(moduleType); 
		
		if (moduleType == EnumDirModuleType.我的文档.getValue()) {
			entity.setCreator_id(userId);
		}
		List<Directory> directoryList = directoryDao.selectEntityList(entity);
		if (directoryList != null && directoryList.size() > 0) {
			ZTreeNode rootNode = new ZTreeNode("根目录");
			treeList = entity.buildTreeList(directoryList);
			treeList.add(rootNode);
		}
		return treeList;
	}

	/**
	 * @Description 获取共享文件夹
	 * @param deptId
	 * @param moduleType
	 * @return List<ZTreeNode>
	 */
	public List<ZTreeNode> queryShareTreeList(Integer deptId, Integer moduleType) {
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();
		Directory entity = new Directory();
		entity.setModule_type(moduleType);
		entity.getMap().put("share", true);
		// 根据当前用户所在部门获取文件夹
		DirectoryDept dirDept = new DirectoryDept(deptId);
		List<DirectoryDept> dirDeptList = directoryDeptDao.selectEntityList(dirDept);
		if (dirDeptList != null && !dirDeptList.isEmpty()) {
			List<Integer> dirIds = new ArrayList<Integer>();
			for (DirectoryDept item : dirDeptList) {
				if (!dirIds.contains(item.getDirectory_id())) {
					dirIds.add(item.getDirectory_id());
				}
			}
			entity.getMap().put("share_ids", dirIds);
		}

		List<Directory> directoryList = directoryDao.selectEntityList(entity);

		if (directoryList != null && !directoryList.isEmpty()) {
			treeList = entity.buildShareTreeList(directoryList);
		}

		return treeList;
	}

	/**
	 * @Description 获取总结文件夹
	 * @param userId
	 * @param parentId
	 * @param moduleType
	 * @return List<ZTreeNode>
	 */
	public List<ZTreeNode> querySummaryTreeList(Integer userId, Integer parentId, Integer moduleType) {
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();

		Directory entity = new Directory();
		entity.setModule_type(moduleType);
		entity.setCreator_id(userId);
		if (parentId == 0) {
			entity.setLayer(1);
		} else {
			entity.setParent_id(parentId);
		}
		List<Directory> directoryList = directoryDao.selectEntityList(entity);
		if (directoryList != null && directoryList.size() > 0) {
			ZTreeNode nodeItem = null;
			for (Directory directory : directoryList) {
				nodeItem = directory.buildAsyncTreeNode(parentId);
				treeList.add(nodeItem);
			}
		}
		return treeList;
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Directory entity) {
		// 若要获取id，请使用entity.getId();
		entity.setCreate_time(new Date());
		int result = directoryDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的文档.getValue(), "添加文件夹","添加文件夹：" + entity.getName());
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
	public JsonResult modify(Directory entity) {
		int result = directoryDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的文档.getValue(), "修好文件夹","修好文件夹I：" + entity.getName());
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 共享
	 * @param ids
	 * @param isShareAll
	 * @param deptIds
	 * @return JsonResult
	 */
	public JsonResult modifyForShare(String ids, boolean isShareAll, String deptIds) {
		Directory entity = new Directory();
		entity.setIs_share(true);
		entity.setIs_share_all(isShareAll);
		String[] array = ids.split(",");
		entity.getMap().put("ids", array);
		int result = directoryDao.updateEntity(entity);

		// 添加文件夹共享部门
		if (!isShareAll && StringUtils.isNotBlank(deptIds)) {
			String[] deptArray = deptIds.split(",");
			DirectoryDept directoryDept = null;
			Integer directoryId = 0, deptId = 0;
			for (String item : array) {
				directoryId = NumberUtils.toInt(item, 0);
				if (directoryId == 0) {
					continue;
				}
				for (String subItem : deptArray) {
					deptId = NumberUtils.toInt(subItem, 0);
					if (deptId == 0) {
						continue;
					}
					directoryDept = new DirectoryDept(directoryId, deptId);
					directoryDeptDao.insertEntity(directoryDept);
				}
			}
		}
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的文档.getValue(), "共享文件夹","共享文件夹ID：" + ids);
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 取消共享
	 * @param ids
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modifyForUnshare(String ids) {
		Directory entity = new Directory();
		entity.setIs_share(false);
		entity.setIs_share_all(false);
		String[] array = ids.split(",");
		entity.getMap().put("ids", array);
		int result = directoryDao.updateEntity(entity);

		// 删除文件夹共享部门
		DirectoryDept deptEntity = new DirectoryDept();
		deptEntity.getMap().put("directory_ids", array);
		directoryDeptDao.deleteEntity(deptEntity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的文档.getValue(), "取消共享文件夹","取消共享文件夹ID：" + ids);
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据Id删除
	 * @param id
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult removeById(Integer id) {
		Directory entity = new Directory();
		entity.setId(id);
		int result = directoryDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的文档.getValue(), "删除文件夹","删除文件夹ID：" + id);
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
		String[] idArray = ids.split(",");
		// 批量删除文件夹
		Directory entity = new Directory();
		entity.getMap().put("ids", idArray);
		int result = directoryDao.deleteEntity(entity);
		if (result > 0) {
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
	public JsonResult remove(Directory entity) {
		int result = directoryDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
