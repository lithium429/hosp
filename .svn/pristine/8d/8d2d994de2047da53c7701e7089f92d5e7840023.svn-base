package com.xz.oa.core.dao.mybatis.forum;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.forum.ForumUserDao;
import com.xz.oa.core.domain.entity.ForumUser;

@Repository
public class ForumUserDaoSqlMapImpl extends BaseDaoSqlMapImpl<ForumUser> implements ForumUserDao {

	/* 
	 * 更新板块最新信息 
	 */
	public int updateForumUserCount(ForumUser entity) {
		return super.sqlSessionDefault.update("updateForumUserCount", entity);
	}
}

