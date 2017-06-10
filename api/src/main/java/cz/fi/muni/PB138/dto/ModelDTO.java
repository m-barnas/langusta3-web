package cz.fi.muni.PB138.dto;

import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.WordClass;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class ModelDTO {

    private String pattern;
    private String infinitive;
    private WordClass wordClass;
    private List<GenderDTO> genders = new ArrayList<>();

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public WordClass getWordClass() {
        return wordClass;
    }

    public void setWordClass(WordClass wordClass) {
        this.wordClass = wordClass;
    }

    public List<GenderDTO> getGenders() {
        return genders;
    }

    public void setGenders(List<GenderDTO> genders) {
        this.genders = genders;
    }
}
