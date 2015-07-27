package com.xz.oa.sso.service.unionnet.proxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2014-08-22T14:43:54.398+08:00
 * Generated source version: 2.7.12
 * 
 */
@WebServiceClient(name = "ESBProviderService", 
                  wsdlLocation = "http://192.168.2.16:803/UniESBService.wsdl",
                  targetNamespace = "http://SHTH.ESB.ServiceProvider/") 
public class ESBProviderService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://SHTH.ESB.ServiceProvider/", "ESBProviderService");
    public final static QName ESBProviderServiceSoap12 = new QName("http://SHTH.ESB.ServiceProvider/", "ESBProviderServiceSoap12");
    public final static QName ESBProviderServiceSoap = new QName("http://SHTH.ESB.ServiceProvider/", "ESBProviderServiceSoap");
    static {
        URL url = null;
        try {
            url = new URL("http://192.168.2.16:803/UniESBService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ESBProviderService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://192.168.2.16:803/UniESBService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ESBProviderService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ESBProviderService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ESBProviderService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns ESBProviderServiceSoap
     */
    @WebEndpoint(name = "ESBProviderServiceSoap12")
    public ESBProviderServiceSoap getESBProviderServiceSoap12() {
        return super.getPort(ESBProviderServiceSoap12, ESBProviderServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ESBProviderServiceSoap
     */
    @WebEndpoint(name = "ESBProviderServiceSoap12")
    public ESBProviderServiceSoap getESBProviderServiceSoap12(WebServiceFeature... features) {
        return super.getPort(ESBProviderServiceSoap12, ESBProviderServiceSoap.class, features);
    }
    /**
     *
     * @return
     *     returns ESBProviderServiceSoap
     */
    @WebEndpoint(name = "ESBProviderServiceSoap")
    public ESBProviderServiceSoap getESBProviderServiceSoap() {
        return super.getPort(ESBProviderServiceSoap, ESBProviderServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ESBProviderServiceSoap
     */
    @WebEndpoint(name = "ESBProviderServiceSoap")
    public ESBProviderServiceSoap getESBProviderServiceSoap(WebServiceFeature... features) {
        return super.getPort(ESBProviderServiceSoap, ESBProviderServiceSoap.class, features);
    }

}
