/**   
* @Title: EnumSmsState.java 
* @Package: com.xz.oa.core.domain.enums 
* @Description: 
* @author: davidwan
* @date: 2014-8-20 下午10:11:15 
* @version: V1.0   
*/
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumSmsState {
	成功(1), 失败(2);

	private final int value;

	private static final Map<Integer, EnumSmsState> map = new HashMap<Integer, EnumSmsState>();

	static {
		for (EnumSmsState obj : EnumSmsState.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumSmsState(int value) {
		this.value = value;
	}

	public static EnumSmsState fromInt(int i) {
		EnumSmsState obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumSmsState.成功;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}