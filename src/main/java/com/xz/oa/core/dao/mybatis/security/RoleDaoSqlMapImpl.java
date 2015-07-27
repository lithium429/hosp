package com.xz.oa.core.dao.mybatis.security;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.security.RoleDao;
import com.xz.oa.core.domain.entity.Role;

@Repository
public class RoleDaoSqlMapImpl extends BaseDaoSqlMapImpl<Role> implements RoleDao {

}

