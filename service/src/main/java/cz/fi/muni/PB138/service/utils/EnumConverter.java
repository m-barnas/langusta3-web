package cz.fi.muni.PB138.service.utils;

import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.WordClass;
import cz.fi.muni.PB138.enums.Number;

/**
 * Created by Martin on 10.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class EnumConverter {

    public static String wordClassToStr(WordClass wordClass) {
        if (wordClass == null) {
            return null;
        }
        switch (wordClass) {
            case Noun:
                return "noun";
            case Adjective:
                return "adjective";
            case Verb:
                return "verb";
            case Adverb:
                return "adverb";
            case Pronoun:
                return "pronoun";
            case Preposition:
                return "preposition";
            default:
                return null;
        }
    }

    public static String grammaticalGenderToStr(GrammaticalGender grammaticalGender) {
        if (grammaticalGender == null) {
            return null;
        }
        switch (grammaticalGender) {
            case MasculineAnimate:
                return "masculineanimate";
            case MasculineInanimate:
                return "masculineinanimate";
            case Feminine:
                return "feminine";
            case Neuter:
                return "neuter";
            default:
                return null;
        }
    }

    public static String numberToStr(Number number) {
        if (number == null) {
            return null;
        }
        switch (number) {
            case Singular:
                return "singular";
            case Plural:
                return "plural";
            default:
                return null;
        }
    }

    public static String grammaticalCaseToStr(GrammaticalCase grammaticalCase) {
        if (grammaticalCase == null) {
            return null;
        }
        switch (grammaticalCase) {
            case Nominative:
                return "nominative";
            case Genitive:
                return "genitive";
            case Dative:
                return "dative";
            case Accusative:
                return "accusative";
            case Vocative:
                return "vocative";
            case Locative:
                return "locative";
            case Instrumental:
                return "instrumental";
            default:
                return null;
        }
    }


}
