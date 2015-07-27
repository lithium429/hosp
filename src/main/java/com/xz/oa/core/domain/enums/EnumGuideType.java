/**   
* @Title: EnumGuideType.java 
* @Package: com.xz.oa.core.domain.enums 
* @Description: 
* @author: davidwan
* @date: 2014-9-30 上午9:31:03 
* @version: V1.0   
*/
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumGuideType {
	最热主题(1), 最新回复(2), 最新发表(3);

	private final int value;

	private static final Map<Integer, EnumGuideType> map = new HashMap<Integer, EnumGuideType>();

	static {
		for (EnumGuideType obj : EnumGuideType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumGuideType(int value) {
		this.value = value;
	}

	public static EnumGuideType fromInt(int i) {
		EnumGuideType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumGuideType.最热主题;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
