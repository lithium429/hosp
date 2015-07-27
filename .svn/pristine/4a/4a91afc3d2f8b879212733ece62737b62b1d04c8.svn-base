package com.xz.oa.core.service.book;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.dao.book.BookBorrowRecordDao;
import com.xz.oa.core.dao.book.BookDao;
import com.xz.oa.core.domain.entity.Book;
import com.xz.oa.core.domain.entity.BookBorrowRecord;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class BookBorrowRecordService {

	@Resource
	private BookBorrowRecordDao bookBorrowRecordDao;

	@Resource
	private BookDao bookDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return BookBorrowRecord
	 * @author davidwan
	 */
	public BookBorrowRecord findById(Integer id) {
		BookBorrowRecord entity = new BookBorrowRecord();
		entity.setId(id);
		return bookBorrowRecordDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return BookBorrowRecord
	 * @author davidwan
	 */
	public BookBorrowRecord find(BookBorrowRecord entity) {
		return bookBorrowRecordDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<BookBorrowRecord>
	 * @author davidwan
	 */
	public List<BookBorrowRecord> queryList(BookBorrowRecord entity) {
		return bookBorrowRecordDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<BookBorrowRecord>
	 * @author davidwan
	 */
	public PageInfo<BookBorrowRecord> queryPageList(BookBorrowRecord entity, int pageIndex, int pageSize) {
		return bookBorrowRecordDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(BookBorrowRecord entity) {
		// 若要获取id，请使用entity.getId();
		int result = bookBorrowRecordDao.insertEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 修改
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modify(BookBorrowRecord entity) {
		int result = bookBorrowRecordDao.updateEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据Id删除
	 * @param id
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult removeById(Integer id) {
		BookBorrowRecord entity = new BookBorrowRecord();
		entity.setId(id);
		int result = bookBorrowRecordDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据多个Id删除
	 * @param ids
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult removeByIds(String ids) {
		BookBorrowRecord entity = new BookBorrowRecord();
		entity.getMap().put("ids", ids.split(","));
		int result = bookBorrowRecordDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据指定条件删除
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult remove(BookBorrowRecord entity) {
		int result = bookBorrowRecordDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 修改
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modifyChange(int id,int book_id, String ids,String book_ids, int state) {
		Book b=new Book();
		b.setIs_borrow(false);
		BookBorrowRecord entity = new BookBorrowRecord();
		entity.setBorrow_state(state);
		if (id == 0) {
			entity.getMap().put("ids", ids.split(","));
			if(state==3 && !StringUtil.isNullOrEmpty(book_ids))
			{
				b.getMap().put("ids", book_ids.split(","));
				bookDao.updateEntity(b);
			}
		} else {
			entity.setId(id);
			if(state==3 && book_id!=0)
			{
				b.setId(book_id);
				bookDao.updateEntity(b);
			}
		}
		int result = bookBorrowRecordDao.updateEntity(entity);

		if (result > 0) {
			String action="审核通过";
			if(state==3)
			{
				action="归还";
			}
			//添加操作日志
			systemLogService.create(EnumLogModule.借阅明细.getValue(), action+"借阅申请记录",action+"借阅申请记录ID：" + (id==0?ids:id));
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
