package com.xz.oa.core.dao.forum;

import com.xz.base.dao.BaseDao; 
import com.xz.oa.core.domain.entity.ForumThread;

public interface ForumThreadDao extends BaseDao<ForumThread> {
	/**
	 * @Description 更新主题查看次数
	 * @param entity
	 * @return int     
	 */
	public int updateThreadViewCount(ForumThread entity);
}