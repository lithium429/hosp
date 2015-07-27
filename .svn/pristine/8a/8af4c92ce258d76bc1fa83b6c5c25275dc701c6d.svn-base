package com.xz.oa.core.dao.mybatis.forum;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.forum.ForumThreadDao;
import com.xz.oa.core.domain.entity.ForumThread;

@Repository
public class ForumThreadDaoSqlMapImpl extends BaseDaoSqlMapImpl<ForumThread> implements ForumThreadDao {

	/* 
	 * 更新主题浏览次数
	 */ 
	public int updateThreadViewCount(ForumThread entity) {
		 return super.sqlSessionDefault.update("updateForumThreadViewCount", entity);
	}

}

