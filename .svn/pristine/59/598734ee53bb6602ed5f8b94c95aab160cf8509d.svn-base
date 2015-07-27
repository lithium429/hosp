/**   
 * @Title: EnumFileType.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-23 下午6:23:15 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumDirModuleType {
	我的文档(1), 总结文档(2);

	private final int value;

	private static final Map<Integer, EnumDirModuleType> map = new HashMap<Integer, EnumDirModuleType>();

	static {
		for (EnumDirModuleType obj : EnumDirModuleType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumDirModuleType(int value) {
		this.value = value;
	}

	public static EnumDirModuleType fromInt(int i) {
		EnumDirModuleType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumDirModuleType.我的文档;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
