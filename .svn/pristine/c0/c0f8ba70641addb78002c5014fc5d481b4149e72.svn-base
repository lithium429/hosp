package com.xz.oa.core.web.controller.book;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import com.xz.oa.core.domain.entity.BookBorrow;
import com.xz.oa.core.domain.entity.BookType;
import com.xz.oa.core.service.book.BookBorrowService;
import com.xz.oa.core.service.book.BookService;
import com.xz.oa.core.service.book.BookTypeService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/bookBorrow")
public class BookBorrowController extends SpringBaseController {

	@Resource
	private BookBorrowService bookBorrowService;
	@Resource
	private BookTypeService bookTypeService;
	@Resource
	private BookService bookService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		getList(request, model);
		model.addAttribute("typeList", getTypeList());
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
		model.addAttribute("typeList", getTypeList());
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
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		String name = WebUtil.getString(request, "name", "");
		int type_id = WebUtil.getInt(request, "type_id", 0);
		int type = WebUtil.getInt(request, "type", 0);
		int verify_state = WebUtil.getInt(request, "verify_state", 0);
		String author = WebUtil.getString(request, "author", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		BookBorrow entity = new BookBorrow();
		if (verify_state != 0) {
			entity.setVerify_state(verify_state);
		}
		if (StringUtils.isNotBlank(name)) {
			entity.getMap().put("name", name);
		}
		if (StringUtils.isNotBlank(author)) {
			entity.getMap().put("author", author);
		}
		if (type_id != 0) {
			entity.getMap().put("type_id", type_id);
		}
		if(type==0)
		{
			entity.getMap().put("creator_id", shiroUser.getId());
		}
		entity.getMap().put("sort", true);
		PageInfo<BookBorrow> pageInfo = bookBorrowService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("type", type);
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
	JsonResult add(BookBorrow entity) {
		return bookBorrowService.create(entity);
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
		BookBorrow entity = bookBorrowService.findById(id);
		model.addAttribute("model", entity);
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
	JsonResult update(BookBorrow entity) {
		return bookBorrowService.modify(entity);
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
		return bookBorrowService.removeById(id);
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
		return bookBorrowService.removeByIds(ids);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/view")
	public String view(Integer id, Model model,int state,int type) {
		BookBorrow entity = bookBorrowService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("state", state);
		model.addAttribute("type", type);
		return getPathView();
	}

	// 获取公告类型集合
	public List<BookType> getTypeList() {
		BookType at = new BookType();
		at.getMap().put("sort_order", true);
		return bookTypeService.queryList(at);
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/seldatalist")
	public String seldatalist(HttpServletRequest request, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		int type_id = WebUtil.getInt(request, "type_id", 0);
		String name = WebUtil.getString(request, "name", "");

		Book entity = new Book();
		if (StringUtils.isNotBlank(name)) {
			entity.getMap().put("name", name);
		}
		if (type_id != 0) {
			entity.setType_id(type_id);
		}
		entity.getMap().put("sel_book", shiroUser.getId());
		entity.setState(1);
		entity.setIs_borrow(false);
		model.addAttribute("list", bookService.queryList_help(entity));
		return getPath("seldata_list");
	}

	/**
	* @Title: haddle
	* @Description: 进入退回页面
	* @param id
	* @param model
	* @return String
	*/
	@RequestMapping("check")
	public String check(HttpServletRequest request,Integer id, Model model) {
		int state=WebUtil.getInt(request, "state", 0);
		model.addAttribute("state", state);
		int book_id = WebUtil.getInt(request, "book_id", 0);
		model.addAttribute("id", id);
		model.addAttribute("book_id", book_id);
		return getPath("change");
	}

	/**
	 * @Title: delete
	 * @Description: Ajax删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult change(HttpServletRequest request, int state) {
		int id = WebUtil.getInt(request, "id", 0);
		int book_id = WebUtil.getInt(request, "book_id", 0);
		String ids = WebUtil.getString(request, "ids", "");
		String ids1 = WebUtil.getString(request, "ids1", "");
		String content = WebUtil.getString(request, "content", "");
		return bookBorrowService.modifyChange(id, book_id, ids, ids1,state,content);
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "bookBorrow";
	}

	@Override
	public String getModuleName() {
		return "借阅审批";
	}
}
