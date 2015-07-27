/**   
* @Title: UserDao.java 
* @Package: com.xz.oa.core.dao 
* @Description: 用户Dao接口
* @author: davidwan
* @date: 2014-7-14 上午10:26:56 
* @version: V1.0   
*/ 
package com.xz.oa.core.dao.user;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.xz.base.dao.BaseDao; 
import com.xz.oa.core.domain.entity.User;
import com.xz.oa.core.domain.entity.UserHelp;

public interface UserDao extends BaseDao<User>{

	/* 
	 * 获取用户帮助列表
	 */
	public List<UserHelp> selectEntityListHelp(User entity) throws DataAccessException;
}
