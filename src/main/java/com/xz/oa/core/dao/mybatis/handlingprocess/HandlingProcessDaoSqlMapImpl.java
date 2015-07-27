package com.xz.oa.core.dao.mybatis.handlingprocess;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.handlingprocess.HandlingProcessDao;
import com.xz.oa.core.domain.entity.HandlingProcess;

@Repository
public class HandlingProcessDaoSqlMapImpl extends BaseDaoSqlMapImpl<HandlingProcess> implements HandlingProcessDao {
	/*
	 * 获取最大编码
	 */ 
	public String selectEntityCode(HandlingProcess entity) throws DataAccessException { 
		return (String)  super.sqlSessionDefault.selectOne("selectHandlingProcessCode", entity);
	}
}

