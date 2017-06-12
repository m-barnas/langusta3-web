package cz.fi.muni.PB138.dto;

import cz.fi.muni.PB138.enums.WordClass;

/**
 * Created by Erik Macej 433744 , on 11.6.17.
 *
 * @author Erik Macej 433744
 */
public class PatternBaseDTO {

    private WordClass wordClass;
    private String id;
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
