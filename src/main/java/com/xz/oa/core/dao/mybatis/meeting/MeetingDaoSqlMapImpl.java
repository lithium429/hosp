package com.xz.oa.core.dao.mybatis.meeting;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.meeting.MeetingDao;
import com.xz.oa.core.domain.entity.Meeting;

@Repository
public class MeetingDaoSqlMapImpl extends BaseDaoSqlMapImpl<Meeting> implements MeetingDao {

}

