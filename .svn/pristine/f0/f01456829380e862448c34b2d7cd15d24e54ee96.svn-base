/**   
 * @Title: EnumForumUserCenter.java 
 * @Package: com.xz.oa.core.domain.enums 
 * @Description: 
 * @author: davidwan
 * @date: 2014-10-10 上午9:32:22 
 * @version: V1.0   
 */
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumForumUserCenter {
	个人资料(1), 头像设置(2), 我的主题(3), 我的回帖(4), 我的收藏(5);

	private final int value;

	private static final Map<Integer, EnumForumUserCenter> map = new HashMap<Integer, EnumForumUserCenter>();

	static {
		for (EnumForumUserCenter obj : EnumForumUserCenter.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumForumUserCenter(int value) {
		this.value = value;
	}

	public static EnumForumUserCenter fromInt(int i) {
		EnumForumUserCenter obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumForumUserCenter.个人资料;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
