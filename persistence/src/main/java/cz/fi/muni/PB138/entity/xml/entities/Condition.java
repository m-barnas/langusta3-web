package cz.fi.muni.PB138.entity.xml.entities;

import cz.fi.muni.PB138.enums.TypeOfCondition;
import cz.fi.muni.PB138.utils.adapters.CharnoAdapter;
import cz.fi.muni.PB138.utils.adapters.TypeOfConditionAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by Erik Macej 433744 , on 26.5.17.
 *
 * @author Erik Macej 433744
 */


/**
 * Util class for xml element condition
 */
@XmlRootElement(name = "condition")
@XmlAccessorType(XmlAccessType.NONE)
public class Condition {

    // position of character from the end of word (negative number)
    @XmlAttribute(name = "charno")
    @XmlJavaTypeAdapter(type = String.class, value = CharnoAdapter.class)
    private Integer charno;

    // type of condition
    @XmlAttribute(name = "type")
    @XmlJavaTypeAdapter(type = String.class, value = TypeOfConditionAdapter.class)
    private TypeOfCondition typeOfCondition;

    // value of condition
    @XmlAttribute(name = "value")
    private String value;

    public int getCharno() {
        return charno;
    }

    public void setCharno(Integer charno){
        this.charno = charno;
    }

    public TypeOfCondition getTypeOfCondition() {
        return typeOfCondition;
    }

    public void setTypeOfCondition(TypeOfCondition stringTypeOfCondition) {
        this.typeOfCondition = typeOfCondition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
