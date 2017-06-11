package cz.fi.muni.PB138.dto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
public class ConditionListDTO {

    private String conditionString;
    private Set<Integer> basechanges;
    private Boolean lemma;

    public String getConditionString() {
        return conditionString;
    }

    public void setConditionString(String conditionString) {
        this.conditionString = conditionString;
    }

    public Set<Integer> getBasechanges() {
        return Collections.unmodifiableSet(basechanges);
    }

    public void setBasechanges(Set<Integer> basechanges) {
        this.basechanges = basechanges;
    }

    public Boolean getLemma() {
        return lemma;
    }

    public void setLemma(Boolean lemma) {
        this.lemma = lemma;
    }
}
