/**   
* @Title: ActivitiDao.java 
* @Package: com.xz.oa.core.dao.workflow 
* @Description: 
* @author: davidwan
* @date: 2014-11-28 下午3:07:57 
* @version: V1.0   
*/
package com.xz.oa.core.dao.workflow;

import com.xz.oa.core.domain.entity.Role;
import com.xz.oa.core.domain.entity.Wf_hi_activity;
import com.xz.oa.core.domain.entity.Wf_model_category;

import java.util.List;
import java.util.Map;

public interface ActivitiDao {
	/**
	 * @Description 流程完成后清理detail表中的表单类型数据
	 * @param processInstanceId
	 * @return 
	 * int     
	 */
	public int deleteFormPropertyByProcessInstanceId(String processInstanceId);

	public List<Map<String, String>> findPassedNode(String processInstanceId);

	public void modifyActinst(Map<String, Object> sqlMap);

	public List<Wf_hi_activity> findAllActivitywh();

	public void removeActiwh(int id);

	public Object findRuTaskByCon(Map map);

	public void removeRuTaskById(String taskId);

	public void removeHiActinst(Map map);

	public String findHiTaInByCon(Map map);

	public String findHiActinstByTaskId(String taskId);

	public String findHainstById(String historyActivityId);

	public List<Map> findHainstPartById(
			String id);

	public List<Wf_model_category> findCategorywf();

	public String findCateMaxLaById(String id);

	public void createCate(Wf_model_category category);

	public void modifyCateById(Map map);

	public void removeCateById(String categoryId);

	public void modifyArModelById(String categoryId);

	public void createActiwf(Wf_hi_activity hiActivity);

	public List<Map> findHiActinstByCon(String taskId);

	public void modifyHiAcinst(Map terMap);

	public List<Map> findHiActinstByProId(String processInstanceId);

	public void removeArexecByCon(Map terMap);

	public List<Role> findRoleListByUser(String id);

	public Wf_model_category findCateById(String id);

	public int findArtaskCount(Map map);

	public void modifyAhactinst(Map map);

	public String findCateIdFuzzy(String p_categoryId);

	public String findCateMaxId();
}
