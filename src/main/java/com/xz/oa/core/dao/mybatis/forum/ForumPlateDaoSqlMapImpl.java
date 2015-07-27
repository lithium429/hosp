package com.xz.oa.core.dao.mybatis.forum;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.forum.ForumPlateDao;
import com.xz.oa.core.domain.entity.ForumPlate;

@Repository
public class ForumPlateDaoSqlMapImpl extends BaseDaoSqlMapImpl<ForumPlate> implements ForumPlateDao {

	/* 
	 * 更新板块相关数量
	 */ 
	public int updatePlateCount(ForumPlate entity) {
		 return super.sqlSessionDefault.update("updateForumPlateCount", entity);
	}

	/* 
	 * 更新板块最新信息 
	 */
	public int updateForumPlateLastInfo(ForumPlate entity) {
		return super.sqlSessionDefault.update("updateForumPlateLastInfo", entity);
	}

}

