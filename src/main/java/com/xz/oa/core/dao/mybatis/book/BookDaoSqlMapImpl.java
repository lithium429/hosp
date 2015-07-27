package com.xz.oa.core.dao.mybatis.book;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.book.BookDao;
import com.xz.oa.core.domain.entity.Book;

@Repository
public class BookDaoSqlMapImpl extends BaseDaoSqlMapImpl<Book> implements BookDao {
	/*
	 * 获取最大一维码
	 */ 
	public String selectEntityCode(Book entity) throws DataAccessException { 
		return (String)  super.sqlSessionDefault.selectOne("selectBookCode", entity);
	}
}

