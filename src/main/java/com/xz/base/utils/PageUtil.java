/**   
* @Title: PageUtil.java 
* @Package: com.xz.base.utils 
* @Description: 分页工具栏
* @author: davidwan
* @date: 2014-11-28 下午2:40:38 
* @version: V1.0   
*/
package com.xz.base.utils;

public class PageUtil {
	
	/**
	 * @Description 获取分页的起始索引值 
	 * @param pageIndex
	 * @param pageSize
	 * @return int     
	 */
	public static int gainStartIndex(int pageIndex, int pageSize){
		int startIndex = 0;
		if (pageIndex > 0) {
			startIndex = (pageIndex - 1) * pageSize;
		}
		return startIndex;
	}
	
	/**
	 * @Description 获取分页的结束索引值 
	 * @param pageIndex
	 * @param pageSize
	 * @return int     
	 */
	public static int gainEndIndex(int pageIndex, int pageSize){
		int startIndex = 0;
		if (pageIndex > 0) {
			startIndex = (pageIndex - 1) * pageSize;
		}
		int endIndex = startIndex + pageSize - 1;
		return endIndex;
	}
}
