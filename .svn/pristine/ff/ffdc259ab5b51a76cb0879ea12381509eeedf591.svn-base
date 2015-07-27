package com.xz.oa.core.dao.mybatis.meal;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.meal.MealMenuDao;
import com.xz.oa.core.domain.entity.MealMenu;
import com.xz.oa.core.domain.entity.MealMenuAddUp;

@Repository
public class MealMenuDaoSqlMapImpl extends BaseDaoSqlMapImpl<MealMenu> implements MealMenuDao {
	/* 
	 * 获取列表
	 */
	public List<MealMenuAddUp> selectEntityList(MealMenuAddUp entity) throws DataAccessException {
		return  super.sqlSessionDefault.selectList("selectMealMenuList_addUp", entity);
	}
}

