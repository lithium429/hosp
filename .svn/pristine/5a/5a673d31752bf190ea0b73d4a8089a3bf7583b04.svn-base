/**   
* @Title: EnumMeetingOperateType.java 
* @Package: com.xz.oa.core.domain.enums 
* @Description: 
* @author: davidwan
* @date: 2014-8-13 下午1:52:16 
* @version: V1.0   
*/
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumMeetingOperateType {
	通过(1), 不通过(2), 取消(3);

	private final int value;

	private static final Map<Integer, EnumMeetingOperateType> map = new HashMap<Integer, EnumMeetingOperateType>();

	static {
		for (EnumMeetingOperateType obj : EnumMeetingOperateType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumMeetingOperateType(int value) {
		this.value = value;
	}

	public static EnumMeetingOperateType fromInt(int i) {
		EnumMeetingOperateType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumMeetingOperateType.通过;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
