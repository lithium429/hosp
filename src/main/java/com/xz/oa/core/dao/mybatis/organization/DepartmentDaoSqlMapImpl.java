package com.xz.oa.core.dao.mybatis.organization;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.organization.DepartmentDao;
import com.xz.oa.core.domain.entity.Department;

@Repository
public class DepartmentDaoSqlMapImpl extends BaseDaoSqlMapImpl<Department> implements DepartmentDao {

}

