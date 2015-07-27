package com.xz.oa.sso.service.unionnet.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VerifyUserResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "verifyUserResult"
})
@XmlRootElement(name = "VerifyUserResponse", namespace = "http://SHTH.ESB.ServiceProvider/")
public class VerifyUserResponse {

    @XmlElement(name = "VerifyUserResult", namespace = "http://SHTH.ESB.ServiceProvider/")
    protected String verifyUserResult;

    /**
     * 获取verifyUserResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerifyUserResult() {
        return verifyUserResult;
    }

    /**
     * 设置verifyUserResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerifyUserResult(String value) {
        this.verifyUserResult = value;
    }

}
