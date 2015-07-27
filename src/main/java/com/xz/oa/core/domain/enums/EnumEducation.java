package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumEducation {
			小学(1),
			初中(2),
			高中(3),
			中专(4),
			技校(5),
			大专(6),
			本科(7),
			研究生(8),
			博士(9),
			博士后(10);

	private final int value;

	private static final Map<Integer, EnumEducation> map = new HashMap<Integer, EnumEducation>();

	static {
		for (EnumEducation obj : EnumEducation.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumEducation(int value) {
		this.value = value;
	}

	public static EnumEducation fromInt(int i) {
		EnumEducation obj = map.get(Integer.valueOf(i));
		if (obj == null) {
			return EnumEducation.小学;
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
