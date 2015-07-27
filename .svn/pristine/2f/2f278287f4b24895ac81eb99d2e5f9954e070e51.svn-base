package com.xz.oa.sms.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession; 
import org.springframework.stereotype.Repository;

import com.xz.oa.sms.dao.UnionnetSmsDao;
import com.xz.oa.sms.domain.entity.UnionnetSms;

@Repository
public class UnionnetSmsDaoSqlMapImpl implements UnionnetSmsDao {

	@Resource
	private SqlSession sqlSessionSMS;

	/*
	 *  
	 */
	public int insertEntity(UnionnetSms entity) {
		return this.sqlSessionSMS.update("entity.UnionnetSms.insertUnionnetSms", entity);
	}

	/*
	 *  
	 */
	public int insertEntityList(List<UnionnetSms> list) {
		int result = 0;
		for (UnionnetSms item : list) {
			result = this.sqlSessionSMS.update("entity.UnionnetSms.insertUnionnetSms", item);
		}
		return result;
	}

}
