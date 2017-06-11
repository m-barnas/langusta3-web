package cz.fi.muni.PB138.utils;

import cz.fi.muni.PB138.entity.Word;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

/**
 * Created by Martin on 11.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class WordConverter {

    public static List<String> wordToInfinitive(SortedSet<Word> words) {
        List<String> infinitives = new ArrayList<>();
        for(Word w : words) {
            infinitives.add(w.getInfinitive());
        }
        return infinitives;
    }
}
