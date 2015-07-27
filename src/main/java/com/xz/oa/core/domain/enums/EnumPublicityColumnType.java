/**   
 * @Title: EnumPublicityColumnType.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-12-9 下午4:50:17 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumPublicityColumnType {
	院务公开栏(1), 党务公开栏(2), 奖惩公示栏(3), 其它(4);

	private final int value;

	private static final Map<Integer, EnumPublicityColumnType> map = new HashMap<Integer, EnumPublicityColumnType>();

	static {
		for (EnumPublicityColumnType obj : EnumPublicityColumnType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumPublicityColumnType(int value) {
		this.value = value;
	}

	public static EnumPublicityColumnType fromInt(int i) {
		EnumPublicityColumnType obj = map.get(Integer.valueOf(i));
		if (obj == null) {
			return EnumPublicityColumnType.院务公开栏;
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