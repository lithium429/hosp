/**  
 * @Title: ConfigValue.java
 * @Package com.xz.base.utils
 * @Description: 获取配置属性
 * @author 万书德
 * @date 2013-6-13
 * @version V1.0  
 */
package com.xz.oa.sso.utils;

import java.io.*;
import java.util.Properties;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.base.Charsets;
import com.xz.base.utils.LogHelper;

/**
 * @Description: 获取配置属性
 * 
 */
public class SsoConfigValue {

	/**
	 * @Fields config : 属性配置文件对象
	 */
	private static Properties config = null;

	/**
	 * @Fields PAGE_SIZE : 每页显示记录数
	 */
	public static int PAGE_SIZE = 10;

	static {
		InputStream in = SsoConfigValue.class.getClassLoader().getResourceAsStream("sso/config.properties");
		config = new Properties();
		try {
			config.load(new InputStreamReader(in, Charsets.UTF_8));
			in.close();
			// init();
		} catch (IOException ex) {
			LogHelper.getLogger().error("未找到配置文件", ex);
		}
	}

	/**
	 * @Title: readValue
	 * @Description: 读取属性配置文件中的字符串
	 * @param key
	 * @return String
	 */
	public static String readValue(String key) {
		try {
			String value = config.getProperty(key);
			return value;
		} catch (Exception ex) {
			LogHelper.getLogger().error("读取配置信息出错", ex);
			return null;
		}
	}

	/**
	 * @Description 读取属性配置文件中的字符串，如果异常则返回默认值
	 * @param key
	 * @param defaultValue
	 * @return String
	 * @author davidwan
	 */
	public static String readValue(String key, String defaultValue) {
		try {
			String value = config.getProperty(key);
			return value;
		} catch (Exception ex) {
			LogHelper.getLogger().error("读取配置信息出错", ex);
			return defaultValue;
		}
	}

	/**
	 * @Description 读取属性配置文件中的int值
	 * @param key
	 * @return int
	 * @author davidwan
	 */
	public static int readIntValue(String key) {
		String value = readValue(key);
		return NumberUtils.toInt(value, 0);
	}

	/**
	 * @Description 读取属性配置文件中的int值，如果异常则返回默认值
	 * @param key
	 * @param defaultValue
	 * @return int
	 * @author davidwan
	 */
	public static int readIntValue(String key, int defaultValue) {
		String value = readValue(key);
		return NumberUtils.toInt(value, defaultValue);
	}

	/**
	 * @Description 读取属性配置文件中的long值
	 * @param key
	 * @return long
	 * @author davidwan
	 */
	public static long readLongValue(String key) {
		String value = readValue(key);
		return NumberUtils.toLong(value, 0l);
	}

	/**
	 * @Description 读取属性配置文件中的long值，如果异常则返回默认值
	 * @param key
	 * @param defaultValue
	 * @return long
	 * @author davidwan
	 */
	public static long readLongValue(String key, long defaultValue) {
		String value = readValue(key);
		return NumberUtils.toLong(value, defaultValue);
	}
}
