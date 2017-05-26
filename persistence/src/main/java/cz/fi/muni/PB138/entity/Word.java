package cz.fi.muni.PB138.entity;

import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.Number;
import cz.fi.muni.PB138.enums.WordClass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Martin on 26.5.2017.
 *
 * @author Martin Barnas 433523
 */
@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String infinitive;

    private String pattern;

    @NotNull
    @Column(name = "declined_value", nullable = false)
    private String declinedValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "word_class")
    private WordClass wordClass;

    @Enumerated(EnumType.STRING)
    @Column(name = "grammatical_gender")
    private GrammaticalGender grammaticalGender;

    @Enumerated(EnumType.STRING)
    private Number number;

    @Enumerated(EnumType.STRING)
    @Column(name = "grammatical_case")
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
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return getId().equals(word.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Word{" +
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
