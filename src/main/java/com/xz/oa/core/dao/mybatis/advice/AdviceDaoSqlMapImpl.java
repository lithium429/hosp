package com.xz.oa.core.dao.mybatis.advice;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.advice.AdviceDao;
import com.xz.oa.core.domain.entity.Advice;

@Repository
public class AdviceDaoSqlMapImpl extends BaseDaoSqlMapImpl<Advice> implements AdviceDao {

}

