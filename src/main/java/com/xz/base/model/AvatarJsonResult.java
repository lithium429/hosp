/**   
* @Title: AvatarJsonResult.java 
* @Package: com.xz.base.model 
* @Description: 
* @author: davidwan
* @date: 2014-7-5 下午1:06:51 
* @version: V1.0   
*/
package com.xz.base.model;

import java.io.Serializable;

public class AvatarJsonResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7393398138967498708L;
	
	private Integer status;
	
	public AvatarJsonResult(){
		
	}
	
	public AvatarJsonResult(Integer status){
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	} 
}
