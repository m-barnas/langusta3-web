package cz.fi.muni.PB138.dto;

import java.util.List;

/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class InfinitiveDTO {

    private String inputValue;

    private String infinitive;

    private List<DeclinedWordDTO> patterns;

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public List<DeclinedWordDTO> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<DeclinedWordDTO> patterns) {
        this.patterns = patterns;
    }
}

