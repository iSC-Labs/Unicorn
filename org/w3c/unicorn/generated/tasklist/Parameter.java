//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.06.29 at 06:09:33 PM CEST 
//


package org.w3c.unicorn.generated.tasklist;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for parameter element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="parameter">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{http://www.w3.org/unicorn/tasklist}value" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;attGroup ref="{http://www.w3.org/unicorn/tasklist}generalInfos"/>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "parameter")
public class Parameter {

    @XmlElement(namespace = "http://www.w3.org/unicorn/tasklist", required = true)
    protected List<Value> value;
    @XmlAttribute(name = "default")
    protected String _default;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String name;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String observer;
    @XmlAttribute(required = true)
    protected TParamType type;
    @XmlAttribute
    protected TUi ui;

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Value }
     * 
     * 
     */
    public List<Value> getValue() {
        if (value == null) {
            value = new ArrayList<Value>();
        }
        return this.value;
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefault(String value) {
        this._default = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the observer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObserver() {
        return observer;
    }

    /**
     * Sets the value of the observer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObserver(String value) {
        this.observer = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TParamType }
     *     
     */
    public TParamType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TParamType }
     *     
     */
    public void setType(TParamType value) {
        this.type = value;
    }

    /**
     * Gets the value of the ui property.
     * 
     * @return
     *     possible object is
     *     {@link TUi }
     *     
     */
    public TUi getUi() {
        if (ui == null) {
            return TUi.ADVANCED;
        } else {
            return ui;
        }
    }

    /**
     * Sets the value of the ui property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUi }
     *     
     */
    public void setUi(TUi value) {
        this.ui = value;
    }

}
