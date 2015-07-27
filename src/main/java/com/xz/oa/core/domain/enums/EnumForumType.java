/**   
 * @Title: EnumForumType.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-10-15 上午10:23:56 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumForumType {
	主题(1), 跟帖(2);

	private final int value;

	private static final Map<Integer, EnumForumType> map = new HashMap<Integer, EnumForumType>();

	static {
		for (EnumForumType obj : EnumForumType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumForumType(int value) {
		this.value = value;
	}

	public static EnumForumType fromInt(int i) {
		EnumForumType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumForumType.主题;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
