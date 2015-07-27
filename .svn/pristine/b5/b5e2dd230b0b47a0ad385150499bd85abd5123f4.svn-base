package com.xz.oa.core.dao.mybatis.forum;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.forum.ForumPostDao;
import com.xz.oa.core.domain.entity.ForumPost;

@Repository
public class ForumPostDaoSqlMapImpl extends BaseDaoSqlMapImpl<ForumPost> implements ForumPostDao {

	/* 
	 * 获取主题id列表
	 */
	public List<Integer> selectThreadIds(ForumPost entity) {
		return super.sqlSessionDefault.selectList("selectForumPostThreadIds", entity);
	}

}

