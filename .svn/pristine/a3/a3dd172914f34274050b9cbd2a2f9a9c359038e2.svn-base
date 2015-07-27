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

public enum EnumFileType {
	文档(1), 图片(2), 其它(3);

	private final int value;

	private static final Map<Integer, EnumFileType> map = new HashMap<Integer, EnumFileType>();

	static {
		for (EnumFileType obj : EnumFileType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumFileType(int value) {
		this.value = value;
	}

	public static EnumFileType fromInt(int i) {
		EnumFileType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumFileType.文档;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
