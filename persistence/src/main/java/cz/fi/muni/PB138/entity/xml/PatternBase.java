package cz.fi.muni.PB138.entity.xml;

import cz.fi.muni.PB138.enums.WordClass;
import cz.fi.muni.PB138.utils.adapters.WordClassAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by Erik Macej 433744 , on 11.6.17.
 *
 * @author Erik Macej 433744
 */
@XmlRootElement(name = "pattern")
@XmlAccessorType(XmlAccessType.NONE)
public class PatternBase {

    @XmlAttribute(name = "pos")
    @XmlJavaTypeAdapter(type = String.class, value = WordClassAdapter.class)
    private WordClass wordClass;

    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "parent")
    private String parent;

    public WordClass getWordClass() {
        return wordClass;
    }

    public void setWordClass(WordClass wordClass) {
        this.wordClass = wordClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
