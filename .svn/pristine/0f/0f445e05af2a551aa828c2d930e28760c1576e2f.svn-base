package com.xz.oa.core.dao.mybatis.address;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl; 
import com.xz.oa.core.dao.address.AddressDao;
import com.xz.oa.core.domain.entity.Address;
import com.xz.oa.core.domain.entity.AddressHelp;

@Repository
public class AddressDaoSqlMapImpl extends BaseDaoSqlMapImpl<Address> implements AddressDao {
	/* 
	 * 获取通讯录帮助列表
	 */
	public List<AddressHelp> selectEntityListHelp(Address entity) throws DataAccessException {
		return super.sqlSessionDefault.selectList("selectAddressListHelp", entity);
	}
}

