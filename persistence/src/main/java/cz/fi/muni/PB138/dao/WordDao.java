package cz.fi.muni.PB138.dao;

import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.WordClass;

import java.util.List;

/**
 * Created by Martin on 26.5.2017.
 *
 * @author Martin Barnas 433523
 */
public interface WordDao {


    /**
     * Creates entity word
     *
     * @param word to create
     */
    void create(Word word);

    /**
     * Finds word by id
     *
     * @param id to be searched
     * @return word or null for non-existing id
    */
    Word findById(Long id);

    /**
     * Finds all words
     *
     * @return - list of all words or empty list if none exists
     */
    List<Word> findAll();

    /**
     * 1/4/ Finds infinitives represented by given pattern
     *
     * @param pattern to be searched
     * @return list of words with given pattern or empty list if none exists
     */
    List<String> findInfinitives(String pattern);

    /**
     * 2/ Finds infinitives by number of patterns
     *
     * @param  numberOfPatterns to be searched
     * @return list of words with given number of patterns or empty list if none exists
     */
    List<String> findByNumberOfPatterns(Long numberOfPatterns);

    /**
     * 3/ Finds all occurrences of given declined value
     *
     * @param declinedValue to be searched
     * @return list of words with given declined value or empty list if none exists
     */
    List<Word> findByDeclinedValue(String declinedValue);

    /**
     * 5/ Finds patterns for given word
     *
     * @param declinedValue to be searched
     * @return list of patterns or empty list if none exists
     */
    List<String> findPatterns(String declinedValue);

    /**
     * 6/ Finds all forms for given infinitive and pattern
     *
     * @param infinitive to be searched
     * @param pattern to be searched
     * @return list of forms or empty list if none exists
     */
    List<Word> findAllForms(String infinitive, String pattern);

    /**
     * Finds infinitive for given declined value
     *
     * @param declinedValue to be searched
     * @return infinitive or null if does not exist
     */
    String findInfinitive(String declinedValue);






    /**
     * Finds words by given word class
     *
     * @param  wordClass to be searched
     * @return list of words with given word class or empty list if none exists
     */
    List<Word> findByWordClass(WordClass wordClass);

    /**
     * Finds words by given grammatical gender
     *
     * @param  grammaticalGender to be searched
     * @return list of words with given grammatical gender or empty list if none exists
     */
    List<Word> findByGrammaticalGender(GrammaticalGender grammaticalGender);

    /**
     * Finds words by given number
     *
     * @param  number to be searched
     * @return list of words with given number or empty list if none exists
     */
    List<Word> findByNumber(Number number);

    /**
     * Finds words by given grammatical case
     *
     * @param  grammaticalCase to be searched
     * @return list of words with given grammatical case or empty list if none exists
     */
    List<Word> findByGrammaticalCase(GrammaticalCase grammaticalCase);
}
