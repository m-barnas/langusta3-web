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
public class WordFormDTO {

    private String pattern;

    private String infinitive;

    private GrammaticalGender grammaticalGender;

    private WordClass wordClass;

    private List<DeclinedWordDTO> declinedWordDTOS = new ArrayList<>();


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

    public GrammaticalGender getGrammaticalGender() {
        return grammaticalGender;
    }

    public void setGrammaticalGender(GrammaticalGender grammaticalGender) {
        this.grammaticalGender = grammaticalGender;
    }

    public WordClass getWordClass() {
        return wordClass;
    }

    public void setWordClass(WordClass wordClass) {
        this.wordClass = wordClass;
    }

    public List<DeclinedWordDTO> getDeclinedWordDTOS() {
        return declinedWordDTOS;
    }

    public void setDeclinedWordDTOS(List<DeclinedWordDTO> declinedWordDTOS) {
        this.declinedWordDTOS = declinedWordDTOS;
    }
}
