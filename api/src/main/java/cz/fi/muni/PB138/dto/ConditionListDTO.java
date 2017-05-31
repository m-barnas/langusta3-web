package cz.fi.muni.PB138.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
public class ConditionListDTO {

    private String conditionString;
    private Map<Integer, List<BaseChangeDTO>> basechanges = new HashMap<>();
    private Boolean lemma;

    public String getConditionString() {
        return conditionString;
    }

    public void setConditionString(String conditionString) {
        this.conditionString = conditionString;
    }

    public Map<Integer, List<BaseChangeDTO>> getBasechanges() {
        return basechanges;
    }

    public void setBasechanges(Map<Integer, List<BaseChangeDTO>> basechanges) {
        this.basechanges = basechanges;
    }

    public Boolean getLemma() {
        return lemma;
    }

    public void setLemma(Boolean lemma) {
        this.lemma = lemma;
    }
}
