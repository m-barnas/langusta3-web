package cz.fi.muni.PB138.dao;

import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;

import java.util.List;

/**
 * Created by Martin on 26.5.2017.
 *
 * @author Martin Barnas 433523
 */
public interface WordDao {

    /**
     * Finds word by id
     *
     * @param id id to be searched
     * @return word or null for invalid id
    */
    Word findById(Long id);

    /**
     * Finds all words
     *
     * @return - list of all words or null if none exists
     */
    List<Word> findAll();

    /**
     * Finds words by given infinitive
     *
     * @param infinitive to be searched
     * @return list of words with given infinitive or null if none exists
     */
    List<Word> findByInfinitive(String infinitive);

    /**
     * Finds words by given pattern
     *
     * @param pattern to be searched
     * @return list of words with given pattern or null if none exists
     */
    List<Word> findByPattern(String pattern);

    /**
     * Finds words by given declined value
     *
     * @param declinedValue to be searched
     * @return list of words with given declined value or null if none exists
     */
    List<Word> findByDeclinedValue(String declinedValue);

    /**
     * Finds words by given word class
     *
     * @param  wordClass to be searched
     * @return list of words with given word class or null if none exists
     */
    List<Word> findByWordClass(String wordClass);

    /**
     * Finds words by given grammatical gender
     *
     * @param  grammaticalGender to be searched
     * @return list of words with given grammatical gender or null if none exists
     */
    List<Word> findByGrammaticalGender(GrammaticalGender grammaticalGender);

    /**
     * Finds words by given number
     *
     * @param  number to be searched
     * @return list of words with given number or null if none exists
     */
    List<Word> findByNumber(Number number);

    /**
     * Finds words by given grammatical case
     *
     * @param  grammaticalCase to be searched
     * @return list of words with given grammatical case or null if none exists
     */
    List<Word> findByGrammaticalCase(GrammaticalCase grammaticalCase);



}