package com.xz.oa.core.dao.mybatis.email;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.email.EmailUserDao;
import com.xz.oa.core.domain.entity.EmailUser;

@Repository
public class EmailUserDaoSqlMapImpl extends BaseDaoSqlMapImpl<EmailUser> implements EmailUserDao {

}

