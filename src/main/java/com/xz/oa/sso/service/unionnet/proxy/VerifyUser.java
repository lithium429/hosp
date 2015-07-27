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
 *         &lt;element name="strUserCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strUserPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "strUserCode",
    "strUserPwd"
})
@XmlRootElement(name = "VerifyUser", namespace = "http://SHTH.ESB.ServiceProvider/")
public class VerifyUser {

    @XmlElement(namespace = "http://SHTH.ESB.ServiceProvider/")
    protected String strUserCode;
    @XmlElement(namespace = "http://SHTH.ESB.ServiceProvider/")
    protected String strUserPwd;

    /**
     * 获取strUserCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUserCode() {
        return strUserCode;
    }

    /**
     * 设置strUserCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUserCode(String value) {
        this.strUserCode = value;
    }

    /**
     * 获取strUserPwd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUserPwd() {
        return strUserPwd;
    }

    /**
     * 设置strUserPwd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUserPwd(String value) {
        this.strUserPwd = value;
    }

}
