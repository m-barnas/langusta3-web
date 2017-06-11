package cz.fi.muni.PB138.service.utils;

import cz.fi.muni.PB138.enums.GrammaticalGender;

/**
 * Created by Martin on 10.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class EnumConverter {

    public static String grammaticalGenderToString(GrammaticalGender grammaticalGender) {
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
}
