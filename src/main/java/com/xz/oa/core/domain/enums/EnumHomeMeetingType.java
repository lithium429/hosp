/**   
 * @Title: EnumHomeMeetingType.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-23 下午6:23:15 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumHomeMeetingType {
	本周(1), 未来七天(2);

	private final int value;

	private static final Map<Integer, EnumHomeMeetingType> map = new HashMap<Integer, EnumHomeMeetingType>();

	static {
		for (EnumHomeMeetingType obj : EnumHomeMeetingType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumHomeMeetingType(int value) {
		this.value = value;
	}

	public static EnumHomeMeetingType fromInt(int i) {
		EnumHomeMeetingType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumHomeMeetingType.本周;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
