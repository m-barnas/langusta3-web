package cz.fi.muni.PB138.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class InputValueDTO {

    private String inputValue;
    private List<ModelDTO> patterns = new ArrayList<>();

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public List<ModelDTO> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<ModelDTO> patterns) {
        this.patterns = patterns;
    }
}

