/**   
* @Title: UserDaoSqlMapImpl.java 
* @Package: com.xz.oa.core.dao.mybatis 
* @Description: 用户Dao实现类
* @author: davidwan
* @date: 2014-7-14 上午10:26:56 
* @version: V1.0   
*/
package com.xz.oa.core.dao.mybatis.user;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl; 
import com.xz.oa.core.dao.user.UserDao;
import com.xz.oa.core.domain.entity.User;
import com.xz.oa.core.domain.entity.UserHelp;

@Repository
public class UserDaoSqlMapImpl extends BaseDaoSqlMapImpl<User> implements UserDao{
	/* 
	 * 获取通讯录帮助列表
	 */
	public List<UserHelp> selectEntityListHelp(User entity) throws DataAccessException {
		return  super.sqlSessionDefault.selectList("selectUserListHelp", entity);
	}
}
