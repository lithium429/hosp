package com.xz.oa.core.service.activiti.ext;

import com.xz.oa.core.domain.entity.UserRole;
import com.xz.oa.core.service.user.UserService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomGroupEntityManager extends GroupEntityManager {

	
	private UserService userService;

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	Logger logger = LoggerFactory.getLogger(CustomGroupEntityManager.class);

	@Override
	public List<Group> findGroupsByUser(String userId) {
		List<Group> groupList = new ArrayList<Group>();
		
		List<UserRole> list = userService.findRoleIdByUser(userId);
		for (UserRole role : list) {
			GroupEntity group = new GroupEntity();
			group.setId(String.valueOf(role.getId()));
			group.setName(String.valueOf(role.getId()));
			group.setType("assignment");
			group.setRevision(1);
			groupList.add(group);
		}
		return groupList;
	}
	
	
}
