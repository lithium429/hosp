package com.xz.oa.core.service.rewardpunishment;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.rewardpunishment.RewardPunishmentDao;
import com.xz.oa.core.dao.rewardpunishment.RpFileDao;
import com.xz.oa.core.domain.entity.RewardPunishment;
import com.xz.oa.core.domain.entity.RpFile;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class RewardPunishmentService {

	@Resource
	private RewardPunishmentDao rewardPunishmentDao;

	@Resource
	private RpFileDao rpFileDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return RewardPunishment
	 * @author davidwan
	 */
	public RewardPunishment findById(Integer id) {
		RewardPunishment entity = new RewardPunishment();
		entity.setId(id);
		return rewardPunishmentDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return RewardPunishment
	 * @author davidwan
	 */
	public RewardPunishment find(RewardPunishment entity) {
		return rewardPunishmentDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<RewardPunishment>
	 * @author davidwan
	 */
	public List<RewardPunishment> queryList(RewardPunishment entity) {
		return rewardPunishmentDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<RewardPunishment>
	 * @author davidwan
	 */
	public PageInfo<RewardPunishment> queryPageList(RewardPunishment entity, int pageIndex, int pageSize) {
		return rewardPunishmentDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(RewardPunishment entity) {
		entity.setCreate_time(new Date());

		// 若要获取id，请使用entity.getId();
		int result = rewardPunishmentDao.insertEntity(entity);
		int rp_id = entity.getId();
		// 添加附件
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (RpFile file : entity.getFiles()) {
				file.setRp_id(rp_id);
				file.setCreate_time(new Date());
				this.rpFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.奖惩记录.getValue(), "添加奖惩记录","添加奖惩记录：" + entity.getName());
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
	public JsonResult modify(RewardPunishment entity) {
		if (entity.getRp_date() == null) {
			entity.getMap().put("null_rp_date", true);
		}
		if (entity.getAmount() == null) {
			entity.getMap().put("null_amount", true);
		}
		int result = rewardPunishmentDao.updateEntity(entity);
		int rp_id = entity.getId();
		RpFile s = new RpFile();
		s.setRp_id(rp_id);
		this.rpFileDao.deleteEntity(s);
		// 添加附件
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (RpFile file : entity.getFiles()) {
				file.setRp_id(rp_id);
				file.setCreate_time(new Date());
				this.rpFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.奖惩记录.getValue(), "修改奖惩记录","修改奖惩记录：" + entity.getName());
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
		RewardPunishment entity = new RewardPunishment();
		entity.setId(id);
		int result = rewardPunishmentDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.奖惩记录.getValue(), "删除奖惩记录","删除奖惩记录ID：" + id);
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
		RewardPunishment entity = new RewardPunishment();
		entity.getMap().put("ids", ids.split(","));
		int result = rewardPunishmentDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.奖惩记录.getValue(), "批量删除奖惩记录","批量删除奖惩记录ID：" + ids);
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
	public JsonResult remove(RewardPunishment entity) {
		int result = rewardPunishmentDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
