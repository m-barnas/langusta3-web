package cz.fi.muni.PB138.utils.adapters;

import cz.fi.muni.PB138.entity.xml.util.FormInfo;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.Number;
import cz.fi.muni.PB138.enums.WordClass;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Erik Macej 433744 , on 27.5.17.
 *
 * @author Erik Macej 433744
 */
public class FormInfoAdapter extends XmlAdapter<String, FormInfo> {

    @Override
    public FormInfo unmarshal(String s) throws Exception {
        FormInfo formInfo = new FormInfo();

        String code = s;

        if(code.charAt(0) == '+' || code.charAt(0) == '-'){
            code = code.substring(1);
        }

        formInfo.setCode(code);
        formInfo.setWordClass(wordClassResolver(code.substring(0, 2)));
        formInfo.setGrammaticalGender(grammaticalGenderResolver(code.substring(2,4)));
        formInfo.setNumber(numberResolver(code.substring(4, 6)));
        formInfo.setGrammaticalCase(grammaticalCaseResolver(code.substring(7,8)));

        return formInfo;
    }

    @Override
    public String marshal(FormInfo formInfo) throws Exception {
        return formInfo.getCode();
    }

    private WordClass wordClassResolver(String wordClass){
        switch (wordClass){
            case "k1":
                return WordClass.Noun;
            case "k2":
                return WordClass.Adjective;
            default: return null;
        }
    }

    private GrammaticalGender grammaticalGenderResolver(String grammaticalGender){
        switch (grammaticalGender){
            case "gN":
                return GrammaticalGender.Neuter;
            case "gF":
                return GrammaticalGender.Feminine;
            case "gM":
                return GrammaticalGender.MasculineAnimate;
            case "gI":
                return GrammaticalGender.MasculineInanimate;
            default: return null;
        }
    }

    private Number numberResolver(String number){
        switch (number){
            case "nS":
                return Number.Singular;
            case "nP":
                return Number.Plural;
            default: return null;
        }
    }

    private GrammaticalCase grammaticalCaseResolver(String grammaticalCase){
        int intGramaticalCase = Integer.parseInt(grammaticalCase);

        return (intGramaticalCase >= 1 && intGramaticalCase <= 7) ?
                GrammaticalCase.values()[intGramaticalCase -1] : null;
    }
}
