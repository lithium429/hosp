package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xz.base.domain.BaseEntity;
import com.xz.base.model.ZTreeNode;

public class Directory extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 名称
	 */
	private java.lang.String name;

	/**
	 * 父级id
	 */
	private java.lang.Integer parent_id;

	/**
	 * 以逗号连接的父级id
	 */
	private java.lang.String parent_ids;

	/**
	 * 层级
	 */
	private java.lang.Integer layer;

	/**
	 * 是否共享
	 */
	private java.lang.Boolean is_share;

	/**
	 * 是否对所有部门共享
	 */
	private java.lang.Boolean is_share_all;

	/**
	 * 是否逻辑删除
	 */
	private java.lang.Boolean is_delete;

	/**
	 * 模块类型：1.我的文档，2.总结文档
	 */
	private java.lang.Integer module_type;
	
	/**
	 * creator_id
	 */
	private java.lang.Integer creator_id;

	/**
	 * 创建者名称
	 */
	private java.lang.String creator_name;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	public Directory() {
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setParent_id(java.lang.Integer parent_id) {
		this.parent_id = parent_id;
	}

	public java.lang.Integer getParent_id() {
		return this.parent_id;
	}

	public java.lang.String getParent_ids() {
		return parent_ids;
	}

	public void setParent_ids(java.lang.String parent_ids) {
		this.parent_ids = parent_ids;
	}

	public void setLayer(java.lang.Integer layer) {
		this.layer = layer;
	}

	public java.lang.Integer getLayer() {
		return this.layer;
	}

	public void setIs_share(java.lang.Boolean is_share) {
		this.is_share = is_share;
	}

	public java.lang.Boolean getIs_share() {
		return this.is_share;
	}

	public java.lang.Boolean getIs_share_all() {
		return is_share_all;
	}

	public void setIs_share_all(java.lang.Boolean is_share_all) {
		this.is_share_all = is_share_all;
	}

	public void setIs_delete(java.lang.Boolean is_delete) {
		this.is_delete = is_delete;
	}

	public java.lang.Boolean getIs_delete() {
		return this.is_delete;
	}

	public void setModule_type(java.lang.Integer module_type) {
		this.module_type = module_type;
	}

	public java.lang.Integer getModule_type() {
		return this.module_type;
	}

	public void setCreator_id(java.lang.Integer creator_id) {
		this.creator_id = creator_id;
	}

	public java.lang.Integer getCreator_id() {
		return this.creator_id;
	}

	public java.lang.String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	/**
	 * @Description 构造异步请求的树节点 
	 * @param parentId
	 * @return ZTreeNode     
	 */
	public ZTreeNode buildAsyncTreeNode(Integer parentId) {
		ZTreeNode nodeItem = new ZTreeNode();
		nodeItem.setId(this.id);
		nodeItem.setName(this.name);
		nodeItem.setIsParent(true);
		nodeItem.setShowDeleteBtn(true);
		nodeItem.setShowEditBtn(true);
		nodeItem.setShowShareBtn(true);
		nodeItem.setIsShare(this.is_share);
		nodeItem.setParentId(parentId);
		if (this.getLayer() < 10) {
			nodeItem.setShowAddBtn(true);
		} else {
			nodeItem.setShowAddBtn(false);
		}
		if (this.getIs_share()) {
			nodeItem.setIconSkin("share");
		}
		return nodeItem;
	} 
	
	/**
	 * @Description 构造树列表
	 * @param directoryList
	 * @return List<ZTreeNode>
	 */
	public List<ZTreeNode> buildTreeList(List<Directory> directoryList) {
		if (directoryList.isEmpty()) {
			return null;
		}
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();
		ZTreeNode nodeItem = null;
		for (Directory item : directoryList) {
			nodeItem = new ZTreeNode();
			nodeItem.setId(item.getId());
			nodeItem.setName(item.getName());
			nodeItem.setIsParent(true); 
			nodeItem.setParentId(item.parent_id);
			nodeItem.setPId(item.parent_id);
			nodeItem.setOpen(true);
			nodeItem.setCreatorId(item.getCreator_id());
			treeList.add(nodeItem);
		}

		return treeList;
	}

	/**
	 * @Description 构造树列表
	 * @param directoryList
	 * @return List<ZTreeNode>
	 */
	public List<ZTreeNode> buildShareTreeList(List<Directory> directoryList) {
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();
		Map<String, List<Directory>> map = groupListByCreator(directoryList);
		List<ZTreeNode> tempList = null;
		ZTreeNode rootNode = null;
		int tempId = 0;
		for (String key : map.keySet()) {
			tempId--;
			String[] array = key.split("#s#");
			rootNode = new ZTreeNode(tempId, array[0], "share", Integer.parseInt(array[1]));
			treeList.add(rootNode);
			tempList = buildChildList(tempId, map.get(key));
			if (tempList != null) {
				treeList.addAll(tempList);
			}
		}
		return treeList;
	}

	/**
	 * @Description 根据创建用户分组
	 * @param directoryList
	 * @return Map<String,List<Directory>>
	 */
	private Map<String, List<Directory>> groupListByCreator(List<Directory> directoryList) {
		Map<String, List<Directory>> map = new HashMap<String, List<Directory>>();
		List<Directory> list = null;
		String key = null;
		for (Directory item : directoryList) {
			key = item.creator_name + "#s#" + item.creator_id;
			if (!map.containsKey(key)) {
				list = new ArrayList<Directory>();
				list.add(item);
				map.put(key, list);
			} else {
				list = map.get(key);
				list.add(item);
			}
		}
		return map;
	}

	/**
	 * @Description 构造子节点树
	 * @param rootId
	 * @param directoryList
	 * @return List<ZTreeNode>
	 */
	private List<ZTreeNode> buildChildList(Integer rootId, List<Directory> directoryList) {
		if (directoryList.isEmpty()) {
			return null;
		}
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();
		ZTreeNode nodeItem = null;
		for (Directory item : directoryList) {
			nodeItem = new ZTreeNode();
			nodeItem.setId(item.getId());
			nodeItem.setName(item.getName());
			nodeItem.setIsParent(true);
			nodeItem.setIsShare(item.getIs_share());
			Integer parentId = ensureParentId(rootId, item.getParent_id(), directoryList);
			nodeItem.setParentId(parentId);
			nodeItem.setPId(parentId);
			nodeItem.setIconSkin("share");
			nodeItem.setOpen(true);
			nodeItem.setCreatorId(item.getCreator_id());
			treeList.add(nodeItem);
		}

		return treeList;
	}

	/**
	 * @Description 确认节点的父id是否已经存在，不存在则返回null
	 * @param rootId
	 * @param parentId
	 * @param directoryList
	 * @return Integer
	 */
	private Integer ensureParentId(Integer rootId, Integer parentId, List<Directory> directoryList) {
		if (parentId == null) {
			return rootId;
		}

		for (Directory item : directoryList) {
			if (item.id.equals(parentId)) {
				return parentId;
			}
		}
		return rootId;
	}
}