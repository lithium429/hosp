package com.xz.oa.core.dao.mybatis.scheduling;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.scheduling.SchedulingTimeDao;
import com.xz.oa.core.domain.entity.SchedulingTime;

@Repository
public class SchedulingTimeDaoSqlMapImpl extends BaseDaoSqlMapImpl<SchedulingTime> implements SchedulingTimeDao {

}

