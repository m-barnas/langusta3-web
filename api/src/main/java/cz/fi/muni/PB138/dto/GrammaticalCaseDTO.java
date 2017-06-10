package cz.fi.muni.PB138.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class GrammaticalCaseDTO {

    private List<String> singulars = new ArrayList<>();
    private List<String> plurals = new ArrayList<>();

    public List<String> getSingulars() {
        return singulars;
    }

    public void setSingulars(List<String> singulars) {
        this.singulars = singulars;
    }

    public List<String> getPlurals() {
        return plurals;
    }

    public void setPlurals(List<String> plurals) {
        this.plurals = plurals;
    }
}
