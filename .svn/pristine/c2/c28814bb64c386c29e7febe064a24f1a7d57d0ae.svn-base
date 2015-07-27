package com.xz.oa.core.web.controller.book;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.domain.entity.Book;
import com.xz.oa.core.domain.entity.BookType;
import com.xz.oa.core.service.book.BookService;
import com.xz.oa.core.service.book.BookTypeService;

@Controller
@RequestMapping(value = "/book")
public class BookController extends SpringBaseController {

	@Resource
	private BookService bookService;
	@Resource
	private BookTypeService bookTypeService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		model.addAttribute("typeList", getTypeList());
		getList(request, model);
		return getPathList();
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/datalist")
	public String datalist(HttpServletRequest request, Model model) {
		getList(request, model);
		return getPath("data_list");
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getList(HttpServletRequest request, Model model) {
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int type_id = WebUtil.getInt(request, "type_id", 0);
		int is_borrow = WebUtil.getInt(request, "is_borrow", -1);
		String name = WebUtil.getString(request, "name", "");
		String author = WebUtil.getString(request, "author", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);

		Book entity = new Book();
		if (is_borrow != -1) {
			entity.setIs_borrow(is_borrow == 0 ? false : true);
		}
		if (StringUtils.isNotBlank(name)) {
			entity.getMap().put("name", name);
		}
		if (StringUtils.isNotBlank(author)) {
			entity.getMap().put("author", author);
		}
		if (type_id != 0) {
			entity.setType_id(type_id);
		}
		entity.getMap().put("sort", true);
		PageInfo<Book> pageInfo = bookService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList",super.gainRoleMenu(menu_id) );
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		model.addAttribute("typeList", getTypeList());
		return getPathAdd();
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult add(Book entity) {
		return bookService.create(entity);
	}

	/**
	 * @Title: update
	 * @Description: 进入添加页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/update")
	public String update(Integer id, Model model) {
		Book entity = bookService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("typeList", getTypeList());
		return getPathUpdate();
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult update(Book entity) {
		return bookService.modify(entity);
	}

	/**
	 * @Title: delete
	 * @Description: Ajax删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(Integer id) {
		return bookService.removeById(id);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchdelete", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchDelete(String ids) {
		return bookService.removeByIds(ids);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/view")
	public String view(Integer id, Model model) {
		Book entity = bookService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	// 获取公告类型集合
	public List<BookType> getTypeList() {
		BookType at = new BookType();
		at.getMap().put("sort_order", true);
		return bookTypeService.queryList(at);
	}

	/**
	 * @Title: delete
	 * @Description: Ajax报废
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/scrap", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult scrap(Integer id) {
		Book entity = new Book();
		entity.setId(id);
		entity.setState(2);
		return bookService.modifyScrap(entity);
	}

	/**
	 * @Title: delete
	 * @Description: Ajax报废
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/generateCode", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult generateCode(Integer id) {
		String code = bookService.generateCode();
		return new JsonResult(true, "", code);
	}

	/**
	 * @Title: batchDelete
	 * @Description: 验证名称重名
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public @ResponseBody
	boolean validateName(Integer id, String name) {
		boolean result = bookService.validateName(id, name);
		return result;
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "book";
	}

	@Override
	public String getModuleName() {
		return "图书管理";
	}
}
