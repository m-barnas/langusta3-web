package cz.fi.muni.PB138.dto;

import cz.fi.muni.PB138.enums.WordClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
public class PatternDTO {

    private WordClass wordClass;
    private String id;
    private String parent;
    private List<ConditionListDTO> conditionLists = new ArrayList<>();
    private List<FormDTO> formList = new ArrayList<>();
    private Map<Integer, List<BaseChangeDTO>> allPossibleBasechanges =
            new HashMap<>();

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

    public List<ConditionListDTO> getConditionLists() {
        return conditionLists;
    }

    public void setConditionLists(List<ConditionListDTO> conditionLists) {
        this.conditionLists = conditionLists;
    }

    public List<FormDTO> getFormList() {
        return formList;
    }

    public void setFormList(List<FormDTO> formList) {
        this.formList = formList;
    }

    public Map<Integer, List<BaseChangeDTO>> getAllPossibleBasechanges() {
        return allPossibleBasechanges;
    }

    public void setAllPossibleBasechanges(Map<Integer, List<BaseChangeDTO>> allPossibleBasechanges) {
        this.allPossibleBasechanges = allPossibleBasechanges;
    }
}
