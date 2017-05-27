package cz.fi.muni.PB138.entity.xml.entities;

import cz.fi.muni.PB138.utils.adapters.CharnoAdapter;
import cz.fi.muni.PB138.utils.adapters.FormInfoAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by Erik Macej 433744 , on 27.5.17.
 *
 * @author Erik Macej 433744
 */

/**
 * Util class for xml element form
 */
@XmlRootElement(name = "form")
@XmlAccessorType(XmlAccessType.NONE)
public class Form {

    // base of pattern
    @XmlAttribute(name = "base")
    @XmlJavaTypeAdapter(type = String.class, value = CharnoAdapter.class)
    private Integer base;

    // suffix for gramatical case
    private String suffix;

    // info about form
    @XmlElement(name = "tag")
    @XmlJavaTypeAdapter(type = String.class, value = FormInfoAdapter.class)
    private FormInfo formInfo;

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public String getSuffix() {
        return suffix;
    }

    @XmlElement(name = "suffix")
    public void setSuffix(String suffix) {
        suffix = suffix.replace(",","");
        this.suffix = suffix;
    }

    public FormInfo getFormInfo() {
        return formInfo;
    }

    public void setFormInfo(FormInfo formInfo) {
        this.formInfo = formInfo;
    }
}
