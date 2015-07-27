/**   
 * @Title: WebServiceUtil.java 
 * @Package: com.xz.oa.sso.utils 
 * @Description: 
 * @author: davidwan
 * @date: 2014-8-21 下午3:21:54 
 * @version: V1.0   
 */
package com.xz.oa.sso.utils;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

public class WebServiceUtil {
	
	/**
	 * @Description 调用WebService 
	 * @param wsdlUrl
	 * @param methodName
	 * @param args
	 * @return Object     
	 */
	public static Object invoke(String wsdlUrl, String methodName, Object... args) {
		try {
			JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
			Client client = clientFactory.createClient(wsdlUrl); 
			
			HTTPConduit conduit = (HTTPConduit) client.getConduit(); 
			HTTPClientPolicy policy = new HTTPClientPolicy();
			
			long connTimeout = SsoConfigValue.readLongValue("connTimeout", 2000);
			long receiveTimeout = SsoConfigValue.readLongValue("receiveTimeout", 2000);
			//设置连接超时时间
			policy.setConnectionTimeout(connTimeout);
			//设置请求超时时间
			policy.setReceiveTimeout(receiveTimeout); 
			conduit.setClient(policy);
			
			Object[] result = client.invoke(methodName, args);
			return result != null && result.length > 0 ? result[0] : null;
		} catch (Exception e) {
			return null;
		}

	}
}
