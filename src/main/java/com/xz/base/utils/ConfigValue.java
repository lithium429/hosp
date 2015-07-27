/**  
 * @Title: ConfigValue.java
 * @Package com.xz.base.utils
 * @Description: 获取配置属性
 * @author 万书德
 * @date 2013-6-13
 * @version V1.0  
 */
package com.xz.base.utils;

import java.io.*;
import java.util.Properties;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.base.Charsets;

/**
 * @Description: 获取配置属性
 * 
 */
public class ConfigValue {

	/**
	 * @Fields config : 属性配置文件对象
	 */
	private static Properties config = null;

	/**
	 * @Fields PAGE_SIZE : 每页显示记录数
	 */
	public static int PAGE_SIZE = 10;

	static {
		InputStream in = ConfigValue.class.getClassLoader().getResourceAsStream("config.properties");
		config = new Properties();
		try {
			config.load(new InputStreamReader(in, Charsets.UTF_8));
			in.close();
			init();
		} catch (IOException ex) {
			LogHelper.getLogger().error("未找到配置文件", ex);
		}
	}

	private static void init() {
		String pageSize = readValue("pageSize");
		if (StringUtils.isNotBlank(pageSize)) {
			PAGE_SIZE = Integer.parseInt(pageSize);
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
			if(StringUtils.isBlank(value)){
				return defaultValue;
			}
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
	public static int readIntValue(String key, int defaultValue){
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
	public static long readLongValue(String key, long defaultValue){
		String value = readValue(key);
		return NumberUtils.toLong(value, defaultValue);
	}
	
	/**
	 * @Description 读取属性配置文件中的boolean值
	 * @param key
	 * @return boolean    
	 * @author davidwan 
	 */
	public static boolean readBooleanValue(String key) {
		String value = readValue(key);
		return readBooleanValue(value, false);
	}

	/**
	 * @Description 读取属性配置文件中的boolean值，如果异常则返回默认值
	 * @param key
	 * @param defaultValue
	 * @return boolean    
	 * @author davidwan 
	 */
	public static boolean readBooleanValue(String key, boolean defaultValue){
		String value = readValue(key);
		if(StringUtils.isBlank(value)){
			return false;
		}
		return BooleanUtils.toBoolean(value);
	}
}
