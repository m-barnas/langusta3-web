package cz.fi.muni.PB138.dto;

import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.Number;

/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class DeclinedWordDTO {

    private Long id;

    private String declinedValue;

    private GrammaticalCase grammaticalCase;

    private Number number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeclinedValue() {
        return declinedValue;
    }

    public void setDeclinedValue(String declinedValue) {
        this.declinedValue = declinedValue;
    }

    public GrammaticalCase getGrammaticalCase() {
        return grammaticalCase;
    }

    public void setGrammaticalCase(GrammaticalCase grammaticalCase) {
        this.grammaticalCase = grammaticalCase;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}
