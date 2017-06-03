package cz.fi.muni.PB138.dto;

import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.Number;
import cz.fi.muni.PB138.enums.WordClass;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
public class FormInfoDTO {

    private WordClass wordClass;
    private GrammaticalGender grammaticalGender;
    private Number number;
    private GrammaticalCase grammaticalCase;

    public WordClass getWordClass() {
        return wordClass;
    }

    public void setWordClass(WordClass wordClass) {
        this.wordClass = wordClass;
    }

    public GrammaticalGender getGrammaticalGender() {
        return grammaticalGender;
    }

    public void setGrammaticalGender(GrammaticalGender grammaticalGender) {
        this.grammaticalGender = grammaticalGender;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public GrammaticalCase getGrammaticalCase() {
        return grammaticalCase;
    }

    public void setGrammaticalCase(GrammaticalCase grammaticalCase) {
        this.grammaticalCase = grammaticalCase;
    }

}
