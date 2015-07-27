package com.xz.oa.core.dao.mybatis.book;

import org.springframework.stereotype.Repository;

import com.xz.base.dao.impl.BaseDaoSqlMapImpl;
import com.xz.oa.core.dao.book.BookBorrowRecordDao;
import com.xz.oa.core.domain.entity.BookBorrowRecord;

@Repository
public class BookBorrowRecordDaoSqlMapImpl extends BaseDaoSqlMapImpl<BookBorrowRecord> implements BookBorrowRecordDao {

}

