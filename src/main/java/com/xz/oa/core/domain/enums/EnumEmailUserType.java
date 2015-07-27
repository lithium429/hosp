/**   
 * @Title: EnumEmailUserType.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-23 下午6:23:15 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumEmailUserType {
	发送(1), 接收(2);

	private final int value;

	private static final Map<Integer, EnumEmailUserType> map = new HashMap<Integer, EnumEmailUserType>();

	static {
		for (EnumEmailUserType obj : EnumEmailUserType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumEmailUserType(int value) {
		this.value = value;
	}

	public static EnumEmailUserType fromInt(int i) {
		EnumEmailUserType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumEmailUserType.发送;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
