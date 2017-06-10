package cz.fi.muni.PB138.service.utils;

import java.util.*;

/**
 * Created by Martin on 9.6.2017.
 *
 * @author Martin Barnas 433523
 */
public class Parser {

    /**
     * Splits text into single words, uses special characters
     * as a delimiter
     * Moreover:
     * - removes duplicates
     * - removes null value, if it is present
     *
     * @param text to be parsed
     * @return list of single words
     */
    public static List<String> parseText(String text) {
        String[] words = text.split("[^\\p{L}]");
        for (int i = 0; i < words.length;++i) {
            words[i] = words[i].replaceAll("\\d","");
        }
        Set<String> wordsWithoutDuplicates = new HashSet<>(Arrays.asList(words));
        wordsWithoutDuplicates.remove(null);
        return new ArrayList<>(wordsWithoutDuplicates);
    }
}
