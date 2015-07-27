package com.xz.oa.core.dao.mybatis.email;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.email.EmailReceiverDao;
import com.xz.oa.core.domain.entity.EmailReceiver;

@Repository
public class EmailReceiverDaoSqlMapImpl extends BaseDaoSqlMapImpl<EmailReceiver> implements EmailReceiverDao {

}

