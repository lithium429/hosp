/**   
 * @Title: EnumAnnouncementState.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-23 下午6:23:15 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumAnnouncementState {
	未发布(1), 生效(2), 终止(3);

	private final int value;

	private static final Map<Integer, EnumAnnouncementState> map = new HashMap<Integer, EnumAnnouncementState>();

	static {
		for (EnumAnnouncementState obj : EnumAnnouncementState.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumAnnouncementState(int value) {
		this.value = value;
	}

	public static EnumAnnouncementState fromInt(int i) {
		EnumAnnouncementState obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumAnnouncementState.未发布;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
