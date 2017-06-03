package cz.fi.muni.PB138.entity.xml.util;

import cz.fi.muni.PB138.enums.OperationType;
import cz.fi.muni.PB138.utils.adapters.CharnoAdapter;
import cz.fi.muni.PB138.utils.adapters.OperationTypeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by Erik Macej 433744 , on 27.5.17.
 *
 * @author Erik Macej 433744
 */

/**
 * Util class for xml element basechange
 */

@XmlRootElement(name = "basechange")
@XmlAccessorType(XmlAccessType.NONE)
public class BaseChange {

    // number of base
    @XmlAttribute(name = "no")
    @XmlJavaTypeAdapter(type = String.class, value = CharnoAdapter.class)
    private Integer no;

    // Type of operation
    @XmlAttribute(name = "operation")
    @XmlJavaTypeAdapter(type = String.class, value = OperationTypeAdapter.class)
    private OperationType operationType;

    //value of basechange
    @XmlAttribute(name = "value")
    private String value;

    // position of character from the end of word (negative number)
    @XmlAttribute(name = "charno")
    @XmlJavaTypeAdapter(type = String.class, value = CharnoAdapter.class)
    private Integer charno;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCharno() {
        return charno;
    }

    public void setCharno(Integer charno) {
        this.charno = charno;
    }
}
