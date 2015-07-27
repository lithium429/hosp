/**   
 * @Title: OuterUserTestService.java 
 * @Package: com.xz.sso.service 
 * @Description: 
 * @author: davidwan
 * @date: 2014-8-22 上午11:31:14 
 * @version: V1.0   
 */
package com.xz.sso.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;

import com.xz.oa.sso.service.unionnet.proxy.ESBProviderService;
import com.xz.oa.sso.utils.WebServiceUtil;

public class OuterUserServiceTest {

	@Ignore
	@Test
	public void testWebService() {
		try {
			URL url = new URL("http://wxxt.rz-cn.com:8077/UniESBService.wsdl");
			ESBProviderService service = new ESBProviderService(url);
			String result = service.getESBProviderServiceSoap().verifyUser("248", "248");
			System.out.print(result);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testWebServiceByDynamicClient() {
		Object result = WebServiceUtil.invoke("http://192.168.2.16:808/WebService.asmx?wsdl", "VerifyUser", "davidwan", "david1987");
		System.out.print(result);

	}
}
