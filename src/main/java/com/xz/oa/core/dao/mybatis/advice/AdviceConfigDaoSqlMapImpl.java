package com.xz.oa.core.dao.mybatis.advice;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.advice.AdviceConfigDao;
import com.xz.oa.core.domain.entity.AdviceConfig;

@Repository
public class AdviceConfigDaoSqlMapImpl extends BaseDaoSqlMapImpl<AdviceConfig> implements AdviceConfigDao {

}

