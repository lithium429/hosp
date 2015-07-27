package com.xz.oa.core.dao.mybatis.book;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.book.BookTypeDao;
import com.xz.oa.core.domain.entity.BookType;

@Repository
public class BookTypeDaoSqlMapImpl extends BaseDaoSqlMapImpl<BookType> implements BookTypeDao {

}

