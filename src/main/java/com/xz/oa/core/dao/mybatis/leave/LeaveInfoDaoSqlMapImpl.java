package com.xz.oa.core.dao.mybatis.leave;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl; 
import com.xz.oa.core.dao.leave.LeaveInfoDao;
import com.xz.oa.core.domain.entity.LeaveInfo;

@Repository("leaveInfoDao")
public class LeaveInfoDaoSqlMapImpl extends BaseDaoSqlMapImpl<LeaveInfo> implements LeaveInfoDao {

}

