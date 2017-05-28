package cz.fi.muni.PB138.utils.adapters;

import cz.fi.muni.PB138.enums.WordClass;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */
public class WordClassAdapter extends XmlAdapter<String, WordClass> {
    @Override
    public WordClass unmarshal(String s) throws Exception {
        switch (s){
            case "noun":
                return WordClass.Noun;
            case "verb":
                return WordClass.Verb;
            case "adjective":
                return WordClass.Adjective;
            default: return null;
        }
    }

    @Override
    public String marshal(WordClass wordClass) throws Exception {
        return null;
    }
}
