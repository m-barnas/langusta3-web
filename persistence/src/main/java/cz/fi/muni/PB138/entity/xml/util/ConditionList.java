package cz.fi.muni.PB138.entity.xml.util;

import cz.fi.muni.PB138.utils.adapters.LemmaAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 27.5.17.
 *
 * @author Erik Macej 433744
 */

@XmlRootElement(name = "condition-list")
@XmlAccessorType(XmlAccessType.NONE)
public class ConditionList {

    @XmlElement(name = "condition")
    private List<Condition> conditions = new ArrayList<>();

    @XmlElement(name = "basechange")
    private List<BaseChange> baseChange = new ArrayList<>();

    @XmlAttribute(name = "lemma")
    @XmlJavaTypeAdapter(type = String.class, value = LemmaAdapter.class)
    private Boolean lemma;

    public List<Condition> getConditions() {
        return Collections.unmodifiableList(conditions);
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
        Collections.sort(this.conditions,
                (Condition c1, Condition c2) -> c1.getCharno().compareTo(c2.getCharno()) );
    }

    public Boolean isLemma() {
        return lemma;
    }

    public void setLemma(Boolean lemma) {
        this.lemma = lemma;
    }

    public List<BaseChange> getBaseChange() {
        return baseChange;
    }

    public void setBaseChange(List<BaseChange> baseChange) {
        this.baseChange = baseChange;
    }
}
