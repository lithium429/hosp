package com.xz.oa.core.service.activiti.ext;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomGroupEntityManagerFactory implements SessionFactory {
	
	Logger log=LoggerFactory.getLogger(CustomGroupEntityManagerFactory.class);

	private GroupEntityManager groupEntityManager;

	public void setGroupEntityManager(GroupEntityManager groupEntityManager) {
		this.groupEntityManager = groupEntityManager;
	}

	public Class<?> getSessionType() {
		return GroupIdentityManager.class;
	}

	public Session openSession() {
		return groupEntityManager;
	}

}
