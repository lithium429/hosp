package com.xz.oa.core.service.book;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.book.BookVerifyRecordDao;
import com.xz.oa.core.domain.entity.BookVerifyRecord;

@Service
public class BookVerifyRecordService {

	@Resource
	private BookVerifyRecordDao bookVerifyRecordDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return BookVerifyRecord
	 * @author davidwan
	 */
	public BookVerifyRecord findById(Integer id) {
		BookVerifyRecord entity = new BookVerifyRecord();
		entity.setId(id);
		return bookVerifyRecordDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return BookVerifyRecord
	 * @author davidwan
	 */
	public BookVerifyRecord find(BookVerifyRecord entity) {
		return bookVerifyRecordDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<BookVerifyRecord>
	 * @author davidwan
	 */
	public List<BookVerifyRecord> queryList(BookVerifyRecord entity) {
		return bookVerifyRecordDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<BookVerifyRecord>
	 * @author davidwan
	 */
	public PageInfo<BookVerifyRecord> queryPageList(BookVerifyRecord entity, int pageIndex, int pageSize) {
		return bookVerifyRecordDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(BookVerifyRecord entity) {
		// 若要获取id，请使用entity.getId();
		int result = bookVerifyRecordDao.insertEntity(entity);
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
	public JsonResult modify(BookVerifyRecord entity) {
		int result = bookVerifyRecordDao.updateEntity(entity);
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
		BookVerifyRecord entity = new BookVerifyRecord();
		entity.setId(id);
		int result = bookVerifyRecordDao.deleteEntity(entity);
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
		BookVerifyRecord entity = new BookVerifyRecord();
		entity.getMap().put("ids", ids.split(","));
		int result = bookVerifyRecordDao.deleteEntity(entity);
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
	public JsonResult remove(BookVerifyRecord entity) {
		int result = bookVerifyRecordDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
