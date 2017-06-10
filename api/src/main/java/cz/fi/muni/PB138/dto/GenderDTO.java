package cz.fi.muni.PB138.dto;

import cz.fi.muni.PB138.enums.GrammaticalGender;

/**
 * Created by Martin on 10.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class GenderDTO {

    private GrammaticalGender grammaticalGender;

    private GrammaticalCaseDTO nominative = new GrammaticalCaseDTO();
    private GrammaticalCaseDTO genitive = new GrammaticalCaseDTO();
    private GrammaticalCaseDTO dative = new GrammaticalCaseDTO();
    private GrammaticalCaseDTO accusative = new GrammaticalCaseDTO();
    private GrammaticalCaseDTO vocative = new GrammaticalCaseDTO();
    private GrammaticalCaseDTO locative = new GrammaticalCaseDTO();
    private GrammaticalCaseDTO instrumental = new GrammaticalCaseDTO();

    public GrammaticalGender getGrammaticalGender() {
        return grammaticalGender;
    }

    public void setGrammaticalGender(GrammaticalGender grammaticalGender) {
        this.grammaticalGender = grammaticalGender;
    }

    public GrammaticalCaseDTO getNominative() {
        return nominative;
    }

    public void setNominative(GrammaticalCaseDTO nominative) {
        this.nominative = nominative;
    }

    public GrammaticalCaseDTO getGenitive() {
        return genitive;
    }

    public void setGenitive(GrammaticalCaseDTO genitive) {
        this.genitive = genitive;
    }

    public GrammaticalCaseDTO getDative() {
        return dative;
    }

    public void setDative(GrammaticalCaseDTO dative) {
        this.dative = dative;
    }

    public GrammaticalCaseDTO getAccusative() {
        return accusative;
    }

    public void setAccusative(GrammaticalCaseDTO accusative) {
        this.accusative = accusative;
    }

    public GrammaticalCaseDTO getVocative() {
        return vocative;
    }

    public void setVocative(GrammaticalCaseDTO vocative) {
        this.vocative = vocative;
    }

    public GrammaticalCaseDTO getLocative() {
        return locative;
    }

    public void setLocative(GrammaticalCaseDTO locative) {
        this.locative = locative;
    }

    public GrammaticalCaseDTO getInstrumental() {
        return instrumental;
    }

    public void setInstrumental(GrammaticalCaseDTO instrumental) {
        this.instrumental = instrumental;
    }
}
