package com.xz.oa.core.dao.handlingprocess;

import org.springframework.dao.DataAccessException;

import com.xz.base.dao.BaseDao;
import com.xz.oa.core.domain.entity.HandlingProcess;

public interface HandlingProcessDao extends BaseDao<HandlingProcess> {
	/*
	 * 获取最大编码
	 */ 
	public String selectEntityCode(HandlingProcess entity) throws DataAccessException ;
}