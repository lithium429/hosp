/**   
 * @Title: EnumPositionType.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-12-26 上午11:07:47 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumPositionType {
	普通人员(1), 科主任(2), 职能科室科长(3), 分管院长(4), 院长(5);

	private final int value;

	private static final Map<Integer, EnumPositionType> map = new HashMap<Integer, EnumPositionType>();

	static {
		for (EnumPositionType obj : EnumPositionType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumPositionType(int value) {
		this.value = value;
	}

	public static EnumPositionType fromInt(int i) {
		EnumPositionType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumPositionType.普通人员;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}