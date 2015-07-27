package com.xz.oa.core.dao.book;

import org.springframework.dao.DataAccessException;

import com.xz.base.dao.BaseDao;
import com.xz.oa.core.domain.entity.Book;

public interface BookDao extends BaseDao<Book> {
	/*
	 * 获取最大一维码
	 */ 
	public String selectEntityCode(Book entity) throws DataAccessException ;
}