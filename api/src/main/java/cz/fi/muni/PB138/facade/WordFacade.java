package cz.fi.muni.PB138.facade;

import cz.fi.muni.PB138.dto.GenderDTO;
import cz.fi.muni.PB138.dto.WordDTO;
import cz.fi.muni.PB138.dto.ModelDTO;
import cz.fi.muni.PB138.dto.InputValueDTO;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.WordClass;

import java.util.List;

/**
 * Created by Martin on 7.6.2017.
 *
 * @author Martin Barnas 433523
 */
public interface WordFacade {

    /**
     * Creates entity word
     *
     * @param word to create
     */
    void create(WordDTO word);

    /**
     * Finds word by id
     *
     * @param id to be searched
     * @return word or null for non-existing id
     */
    WordDTO findById(Long id);

    /**
     * Finds all words
     *
     * @return - list of all words or empty list if none exists
     */
    List<WordDTO> findAll();

    /**
     * 1/ Finds infinitives represented by given pattern
     *
     * @param pattern to be searched
     * @return list of words with given pattern or empty list if none exists
     */
    List<String> findInfinitivesByPattern(String pattern);

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
    List<WordDTO> findByDeclinedValue(String declinedValue);

    /**
     * 5/ Finds patterns for given word
     *
     * @param declinedValue to be searched
     * @return list of patterns or empty list if none exists
     */
    List<String> findPatterns(String declinedValue);

    /**
     * 6/ Finds all forms for given infinitive, pattern and gender
     *
     * @param infinitive to be searched
     * @param pattern to be searched
     * @return list of forms or empty list if none exists
     */
    GenderDTO findAllForms(String infinitive, String pattern, GrammaticalGender gender);

    /**
     * 7/ Analyzes given text
     *
     * @param text to be analyzed
     * @return list of words (for each word -> patterns and declined values for each pattern)
     * or empty list if none exists
     */
    List<InputValueDTO> analyze(String text);

    /**
     * Finds all words represented by given patterns
     *
     * @param patterns to be searched
     * @return list of word or empty list if none exists
     */
    List<String> findAllWordsByPatterns(List<String> patterns);









    /**
     * Finds words by given word class
     *
     * @param  wordClass to be searched
     * @return list of words with given word class or empty list if none exists
     */
    List<WordDTO> findByWordClass(WordClass wordClass);

    /**
     * Finds words by given grammatical gender
     *
     * @param  grammaticalGender to be searched
     * @return list of words with given grammatical gender or empty list if none exists
     */
    List<WordDTO> findByGrammaticalGender(GrammaticalGender grammaticalGender);

    /**
     * Finds words by given number
     *
     * @param  number to be searched
     * @return list of words with given number or empty list if none exists
     */
    List<WordDTO> findByNumber(Number number);

    /**
     * Finds words by given grammatical case
     *
     * @param  grammaticalCase to be searched
     * @return list of words with given grammatical case or empty list if none exists
     */
    List<WordDTO> findByGrammaticalCase(GrammaticalCase grammaticalCase);
}
