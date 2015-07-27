package com.xz.oa.core.dao.mybatis.email;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.email.EmailFileDao;
import com.xz.oa.core.domain.entity.EmailFile;

@Repository
public class EmailFileDaoSqlMapImpl extends BaseDaoSqlMapImpl<EmailFile> implements EmailFileDao {

}

