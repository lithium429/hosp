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

public enum EnumMeetingState {
	未开始(1), 进行中(2), 已结束(3), 已取消(4);

	private final int value;

	private static final Map<Integer, EnumMeetingState> map = new HashMap<Integer, EnumMeetingState>();

	static {
		for (EnumMeetingState obj : EnumMeetingState.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumMeetingState(int value) {
		this.value = value;
	}

	public static EnumMeetingState fromInt(int i) {
		EnumMeetingState obj = map.get(Integer.valueOf(i));
		if (obj == null) {
			return EnumMeetingState.未开始;
		}
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
