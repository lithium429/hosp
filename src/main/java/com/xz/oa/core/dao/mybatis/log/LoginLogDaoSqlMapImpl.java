package com.xz.oa.core.dao.mybatis.log;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.log.LoginLogDao;
import com.xz.oa.core.domain.entity.LoginLog;

@Repository
public class LoginLogDaoSqlMapImpl extends BaseDaoSqlMapImpl<LoginLog> implements LoginLogDao {

}

