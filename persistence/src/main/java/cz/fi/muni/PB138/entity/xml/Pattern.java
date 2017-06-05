package cz.fi.muni.PB138.entity.xml;

import cz.fi.muni.PB138.entity.xml.util.BaseChange;
import cz.fi.muni.PB138.entity.xml.util.ConditionList;
import cz.fi.muni.PB138.entity.xml.util.Form;
import cz.fi.muni.PB138.enums.WordClass;
import cz.fi.muni.PB138.utils.adapters.WordClassAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */

@XmlRootElement(name = "pattern")
@XmlAccessorType(XmlAccessType.NONE)
public class Pattern {

    @XmlAttribute(name = "pos")
    @XmlJavaTypeAdapter(type = String.class, value = WordClassAdapter.class)
    private WordClass wordClass;

    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "parent")
    private String parent;

    @XmlElement(name = "condition-list")
    private List<ConditionList> conditionLists = new ArrayList<>();

    @XmlElement(name = "form")
    private List<Form> formList = new ArrayList<>();

    @XmlElement(name = "basechange")
    private List<BaseChange> baseChangeList = new ArrayList<>();

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

    public List<ConditionList> getConditionLists() {
        return Collections.unmodifiableList(conditionLists);
    }

    public void setConditionLists(List<ConditionList> conditionLists) {
        this.conditionLists = conditionLists;
    }

    public List<Form> getFormList() {
        return Collections.unmodifiableList(formList);
    }

    public void setFormList(List<Form> formList) {
        this.formList = formList;
    }

    public List<BaseChange> getBaseChangeList() {
        return Collections.unmodifiableList(baseChangeList);
    }

    public void setBaseChangeList(List<BaseChange> baseChangeList) {
        this.baseChangeList = baseChangeList;
    }
}
