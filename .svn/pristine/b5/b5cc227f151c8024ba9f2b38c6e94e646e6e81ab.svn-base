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
import com.xz.oa.core.dao.book.BookDao;
import com.xz.oa.core.domain.entity.Book;   
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class BookService{

	@Resource
	private BookDao bookDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Book    
	 * @author davidwan 
	 */
	public Book findById(Integer id) {
		Book entity = new Book();
		entity.setId(id);
		return bookDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Book    
	 * @author davidwan 
	 */
	public Book find(Book entity) {
		return bookDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<Book>    
	 * @author davidwan 
	 */
	public List<Book> queryList(Book entity){
		return bookDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<Book>    
	 * @author davidwan 
	 */
	public List<Book> queryList_help(Book entity){
		return bookDao.selectEntityList(entity,"_help");
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Book>    
	 * @author davidwan 
	 */
	public PageInfo<Book> queryPageList(Book entity, int pageIndex, int pageSize){
		return bookDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(Book entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		Book t = new Book();
		Integer sort = bookDao.selectEntitySort(t);
		entity.setSort((sort == null ? 0 : sort) + 1);
		entity.setCreator_id(shiroUser.getId());
		entity.setCode(generateCode());
		entity.setState(1);
		entity.setIs_borrow(false);
		// 若要获取id，请使用entity.getId();
		int result = bookDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.图书管理.getValue(), "添加图书","添加图书：" + entity.getName());
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
	public JsonResult modify(Book entity) {
		int result = bookDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.图书管理.getValue(), "修改图书","修改图书：" + entity.getName());
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
	public JsonResult modifyScrap(Book entity) {
		int result = bookDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.图书管理.getValue(), "报废图书","报废图书ID：" + entity.getId());
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
		Book entity = new Book();
		entity.setId(id);
		int result = bookDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.图书管理.getValue(), "删除图书","删除图书ID：" + entity.getId());
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
		Book entity = new Book();
		entity.getMap().put("ids", ids.split(","));
		int result = bookDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.图书管理.getValue(), "修改图书","修改图书：" + entity.getName());
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
	public JsonResult remove(Book entity) { 
		int result = bookDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	//生成一维码
	public String generateCode()
	{
		Book entity = new Book();
		String r=bookDao.selectEntityCode(entity);
		if(StringUtil.isNullOrEmpty(r))
		{
			r="1000000000001";
		}else
		{
			r=String.valueOf(Long.valueOf(r)+1);
		}
		return r;
	}
	
	//验证名称重名
	public boolean validateName(Integer id, String name) {
		Book t = new Book();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("name_valid", name);
		int count = bookDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
