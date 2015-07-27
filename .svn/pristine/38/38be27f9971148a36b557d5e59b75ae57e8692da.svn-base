/**   
* @Title: EnumNotifyMessageModuleType.java 
* @Package: com.xz.oa.core.domain.enums 
* @Description: 
* @author: davidwan
* @date: 2014-8-12 下午3:39:59 
* @version: V1.0   
*/
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumNotifyMessageModuleType {
	会议(1), 邮件(2), 值班(3), 督办流程(4), 请假(5);

	private final int value;

	private static final Map<Integer, EnumNotifyMessageModuleType> map = new HashMap<Integer, EnumNotifyMessageModuleType>();

	static {
		for (EnumNotifyMessageModuleType obj : EnumNotifyMessageModuleType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumNotifyMessageModuleType(int value) {
		this.value = value;
	}

	public static EnumNotifyMessageModuleType fromInt(int i) {
		EnumNotifyMessageModuleType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumNotifyMessageModuleType.会议;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
