package com.xz.oa.core.service.book;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.dao.book.BookBorrowDao;
import com.xz.oa.core.dao.book.BookBorrowRecordDao;
import com.xz.oa.core.dao.book.BookDao;
import com.xz.oa.core.dao.book.BookVerifyRecordDao;
import com.xz.oa.core.domain.entity.Book;
import com.xz.oa.core.domain.entity.BookBorrow;
import com.xz.oa.core.domain.entity.BookBorrowRecord;
import com.xz.oa.core.domain.entity.BookVerifyRecord;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class BookBorrowService {

	@Resource
	private BookDao bookDao;

	@Resource
	private BookBorrowDao bookBorrowDao;

	@Resource
	private BookBorrowRecordDao bookBorrowRecordDao;

	@Resource
	private BookVerifyRecordDao bookVerifyRecordDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return BookBorrow
	 * @author davidwan
	 */
	public BookBorrow findById(Integer id) {
		BookBorrow entity = new BookBorrow();
		entity.setId(id);
		return bookBorrowDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return BookBorrow
	 * @author davidwan
	 */
	public BookBorrow find(BookBorrow entity) {
		return bookBorrowDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<BookBorrow>
	 * @author davidwan
	 */
	public List<BookBorrow> queryList(BookBorrow entity) {
		return bookBorrowDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<BookBorrow>
	 * @author davidwan
	 */
	public PageInfo<BookBorrow> queryPageList(BookBorrow entity, int pageIndex, int pageSize) {
		return bookBorrowDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(BookBorrow entity) {
		int result = -1;
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		entity.setCreator_id(shiroUser.getId());
		if (entity.getBook_ids() != null) {
			for (String item : entity.getBook_ids().split(",")) {
				entity.setId(null);
				entity.setBook_id(Integer.valueOf(item));
				// 若要获取id，请使用entity.getId();
				result = bookBorrowDao.insertEntity(entity);
			}
		}
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.借阅申请.getValue(), "添加借阅申请","添加借阅申请图书ID：" + entity.getBook_ids());
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
	public JsonResult modify(BookBorrow entity) {
		int result = bookBorrowDao.updateEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			//添加操作日志
			systemLogService.create(EnumLogModule.借阅申请.getValue(), "修改借阅申请","修改借阅申请：" + entity.getName());
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
		BookBorrow entity = new BookBorrow();
		entity.setId(id);
		int result = bookBorrowDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.借阅申请.getValue(), "删除借阅申请","删除借阅申请图书ID：" + id);
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
		BookBorrow entity = new BookBorrow();
		entity.getMap().put("ids", ids.split(","));
		int result = bookBorrowDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.借阅申请.getValue(), "删除借阅申请","删除借阅申请图书ID：" + ids);
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
	public JsonResult remove(BookBorrow entity) {
		int result = bookBorrowDao.deleteEntity(entity);
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
	public JsonResult modifyChange(int id, int book_id, String ids, String book_ids, int state, String content) {
		Book bo = new Book();
		bo.setIs_borrow(true);
		if (book_id != 0) {
			bo.setId(book_id);
		} else {
			bo.getMap().put("ids", book_ids.split(","));
		}
		if (bookDao.selectEntityCount(bo) > 0) {
			return new JsonResult(false, "该图书已借出！");
		}
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		// 借阅审批记录
		BookVerifyRecord b = new BookVerifyRecord();
		b.setBorrow_vstate(state);
		b.setCreate_time(new Date());
		b.setCreator_id(shiroUser.getId());
		b.setContent(content);
		// 借阅审批
		BookBorrow entity = new BookBorrow();
		entity.setVerify_state(state);
		entity.setVerify_content(content);
		entity.setVerify_time(new Date());
		entity.setVerify_user_id(shiroUser.getId());
		// 借阅记录
		BookBorrowRecord br = new BookBorrowRecord();
		br.setCreate_time(new Date());
		br.setBorrow_state(1);
		// 更改书籍是否借阅
		Book t = new Book();
		t.setIs_borrow(true);
		if (id == 0) {
			entity.getMap().put("ids", ids.split(","));
			int i = 0;
			for (String item : ids.split(",")) {
				b.setBorrow_id(Integer.valueOf(item));
				b.setId(null);
				bookVerifyRecordDao.insertEntity(b);
				if (state == 2 && !StringUtil.isNullOrEmpty(book_ids)) {
					br.setId(null);
					br.setBorrow_id(Integer.valueOf(item));
					br.setBook_id(Integer.valueOf(book_ids.split(",")[i]));
					bookBorrowRecordDao.insertEntity(br);
				}
				i++;
			}
			if (state == 2 && !StringUtil.isNullOrEmpty(book_ids)) {
				t.getMap().put("ids", book_ids.split(","));
				bookDao.updateEntity(t);
			}
		} else {
			entity.setId(id);
			b.setBorrow_id(id);
			b.setId(null);
			bookVerifyRecordDao.insertEntity(b);
			if (state == 2 && book_id != 0) {
				br.setBook_id(book_id);
				br.setBorrow_id(id);
				bookBorrowRecordDao.insertEntity(br);
				t.setId(book_id);
				bookDao.updateEntity(t);
			}
		}
		int result = bookBorrowDao.updateEntity(entity);

		if (result > 0) {
			String action="领取";
			if(state==3)
			{
				action="审核不通过";
			}
			//添加操作日志
			systemLogService.create(EnumLogModule.借阅审批.getValue(), action+"借阅申请",action+"借阅申请ID：" + (id==0?ids:id));
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
