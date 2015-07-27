/**   
* @Title: EnumNotifyMessageType.java 
* @Package: com.xz.oa.core.domain.enums 
* @Description: 
* @author: davidwan
* @date: 2014-8-12 下午3:38:15 
* @version: V1.0   
*/
package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumNotifyMessageType {
	系统(1), 用户(2);

	private final int value;

	private static final Map<Integer, EnumNotifyMessageType> map = new HashMap<Integer, EnumNotifyMessageType>();

	static {
		for (EnumNotifyMessageType obj : EnumNotifyMessageType.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumNotifyMessageType(int value) {
		this.value = value;
	}

	public static EnumNotifyMessageType fromInt(int i) {
		EnumNotifyMessageType obj = map.get(Integer.valueOf(i));
		if (obj == null)
			return EnumNotifyMessageType.系统;
		return obj;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}