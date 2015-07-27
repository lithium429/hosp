package com.xz.oa.core.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumNation {
			汉族(1),
	        回族(2),
	        白族(3),
	        保安族(4),
	        布朗族(5),
	        布依族(6),
	        朝鲜族(7),
	        达斡尔族(8),
	        傣族(9),
	        德昂族(10),
	        东乡族(11),
	        侗族(12),
	        独龙族(13),
	        俄罗斯族(14),
	        鄂伦春族(15),
	        鄂温克族(16),
	        高山族(17),
	        仡佬族(18),
	        哈尼族(19),
	        哈萨克族(20),
	        赫哲族(21),
	        基诺族(22),
	        京族(23),
	        景颇族(24),
	        柯尔克孜族(25),
	        拉祜族(26),
	        黎族(27),
	        傈僳族(28),
	        珞巴族(29),
	        满族(30),
	        毛南族(31),
	        门巴族(32),
	        蒙古族(33),
	        苗族(34),
	        仫佬族(35),
	        纳西族(36),
	        怒族(37),
	        普米族(38),
	        羌族(39),
	        撒拉族(40),
	        畲族(41),
	        水族(42),
	        塔吉克族(43),
	        塔塔尔族(44),
	        土家族(45),
	        土族(46),
	        佤族(47),
	        维吾尔族(48),
	        乌孜别克族(49),
	        锡伯族(50),
	        瑶族(51),
	        彝族(52),
	        裕固族(53),
	        藏族(54),
	        壮族(55),
	        阿昌族(56);

	private final int value;

	private static final Map<Integer, EnumNation> map = new HashMap<Integer, EnumNation>();

	static {
		for (EnumNation obj : EnumNation.values()) {
			map.put(obj.value, obj);
		}
	}

	private EnumNation(int value) {
		this.value = value;
	}

	public static EnumNation fromInt(int i) {
		EnumNation obj = map.get(Integer.valueOf(i));
		if (obj == null) {
			return EnumNation.汉族;
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
