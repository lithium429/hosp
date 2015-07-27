/**  
 * @Title: IOHelper.java
 * @Package com.xz.base.utils
 * @Description: IO辅助类
 * @author 万书德
 * @date 2013-11-23
 * @version V1.0  
 */
package com.xz.base.utils;

import java.io.File;

/**
 * @Description: IO辅助类
 * 
 */
public class IOHelper {

	/**
	 * @Title: getFileNameWithoutExt
	 * @Description: TODO
	 * @param fileName
	 * @return String
	 */
	public static String getFileNameWithoutExt(String fileName) {
		String result = "";
		if (StringUtil.isNullOrEmpty(fileName)) {
			return result;
		}
		result = fileName.substring(fileName.lastIndexOf('\\') + 1,
				fileName.lastIndexOf('.'));

		return result;
	}
	
	/**
	* @Title: getFileExt
	* @Description: 获取文件扩展名
	* @param fileName
	* @return String
	*/
	public static String getFileExt(String fileName) {
		String result = "";
		if (StringUtil.isNullOrEmpty(fileName)) {
			return result;
		}
		result = fileName.substring(fileName.lastIndexOf('.'));

		return result;
	}

	/**
	 * @Title: rename
	 * @Description: 重命名【把addText连接到filePath文件路径中】
	 * @param filePath
	 * @param addText
	 * @return String
	 */
	public static String rename(String filePath, String addText) {
		String result = "";
		if (StringUtil.isNullOrEmpty(filePath)) {
			return result;
		}
		StringBuffer buffer = new StringBuffer(filePath);
		int startIndex = filePath.lastIndexOf('.');
		buffer.replace(startIndex, startIndex + 1, addText + ".");

		return buffer.toString();
	}

	/**
	* @Title: markDir
	* @Description: 创建文件夹
	* @param fileType 文件类型
	*/
	public static boolean makeDir(String path){
		boolean flag = true; 
		File directory = new File(path);
		if(!directory.exists()){
			flag = directory.mkdirs();
			if(flag){
				directory.setWritable(true);
				directory.setReadable(true);
			}
			else{
				LogHelper.getLogger().error("未能成功创建文件夹");
			}
		}
		return flag;
	}
}
