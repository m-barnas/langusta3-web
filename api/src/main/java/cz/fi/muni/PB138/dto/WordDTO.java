package cz.fi.muni.PB138.dto;

import javax.validation.constraints.NotNull;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.Number;
import cz.fi.muni.PB138.enums.WordClass;

/**
 * Created by Martin on 7.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class WordDTO {

    private Long id;

    @NotNull
    private String infinitive;

    private String pattern;

    @NotNull
    private String declinedValue;

    private WordClass wordClass;

    private GrammaticalGender grammaticalGender;

    private Number number;

    private GrammaticalCase grammaticalCase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDeclinedValue() {
        return declinedValue;
    }

    public void setDeclinedValue(String declinedValue) {
        this.declinedValue = declinedValue;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordDTO)) return false;

        WordDTO wordDTO = (WordDTO) o;

        return getId().equals(wordDTO.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WordDTO{" +
                "id=" + id +
                ", infinitive='" + infinitive + '\'' +
                ", pattern='" + pattern + '\'' +
                ", declinedValue='" + declinedValue + '\'' +
                ", wordClass=" + wordClass +
                ", grammaticalGender=" + grammaticalGender +
                ", number=" + number +
                ", grammaticalCase=" + grammaticalCase +
                '}';
    }
}
