/**   
 * @Title: EnumLogModule.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-23 下午6:23:15 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumLogModule {
	用户操作(0),
	角色权限(1), 组织架构(2), 公告类型管理(3), 公告管理(4), 公示栏管理(5),
	短信模版(11), 发送短信(12), 我的短信(13), 短信管理(14), 
	写邮件(21), 收件箱(22), 发件箱(23), 草稿箱(24), 邮件回收站(25),
	内部通讯录(31), 外部通讯录(32),
	我的文档(41), 总结文档(42), 文档回收站(43),
	会议室管理(51), 我的会议(52), 会议申请(53), 会议审批(54),
	排班时间段管理(61), 科室排班(62), 总排班表(63),
	图书类型(71), 图书管理(72), 借阅申请(73), 借阅审批(74), 我的图书(75), 借阅明细(76),
	我的督办流程(81), 督办流程管理(82),
	菜单管理(91), 订餐(92), 我的订餐记录(93), 订餐统计(94),
	护理天地(100),
	人员管理(110), 合同类型(111), 人事合同(112), 奖惩名目(113), 奖惩记录(114),
	请假登记(121), 请假审批(122);

	private final int value;

	private static final Map<Integer, EnumLogModule> map = new HashMap<Integer, EnumLogModule>();

	static {
		for (EnumLogModule obj : EnumLogModule.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumLogModule(int value) {
		this.value = value;
	}

	public static EnumLogModule fromInt(int i) {
		EnumLogModule obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumLogModule.角色权限;
		return obj;
	}
	
	public static Map<Integer, EnumLogModule> getMap() {
		return map;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
