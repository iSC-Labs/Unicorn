//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2006.06.29 at 06:09:33 PM CEST 
//


package org.w3c.unicorn.generated.tasklist;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for tUi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tUi">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="simple"/>
 *     &lt;enumeration value="advanced"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum TUi {

    @XmlEnumValue("advanced")
    ADVANCED("advanced"),
    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("simple")
    SIMPLE("simple");
    private final String value;

    TUi(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TUi fromValue(String v) {
        for (TUi c: TUi.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
