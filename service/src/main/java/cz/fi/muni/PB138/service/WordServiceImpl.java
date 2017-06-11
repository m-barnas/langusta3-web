package cz.fi.muni.PB138.service;

import cz.fi.muni.PB138.dao.WordDao;
import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.WordClass;
import cz.fi.muni.PB138.service.utils.EnumConverter;
import cz.fi.muni.PB138.utils.WordConverter;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Martin on 7.6.2017.
 *
 * @author Martin Barnas 433523
 */
@Service
public class WordServiceImpl implements WordService {

    @Inject
    private WordDao wordDao;

    @Override
    public void create(Word word) {
        wordDao.create(word);
    }

    @Override
    public Word findById(Long id) {
        return wordDao.findById(id);
    }

    @Override
    public List<Word> findAll() {
        return wordDao.findAll();
    }

    @Override
    public List<String> findInfinitivesByPattern(String pattern) {
        return wordDao.findInfinitivesByPattern(pattern);
    }

    @Override
    public List<String> findByNumberOfPatterns(Long numberOfPatterns) {
        return wordDao.findByNumberOfPatterns(numberOfPatterns);
    }

    @Override
    public List<String> findPatterns(String declinedValue) {
        return wordDao.findPatterns(declinedValue);
    }

    @Override
    public  List<String> findPatternsByInfinitive(String infinitive) {
        return wordDao.findPatternsByInfinitive(infinitive);
    }

    @Override
    public List<Word> findByDeclinedValue(String declinedValue) {
        return wordDao.findByDeclinedValue(declinedValue);
    }

    @Override
    public List<Word> findAllForms(String infinitive, String pattern) {
        return wordDao.findAllForms(infinitive, pattern);
    }

    @Override
    public List<Word> findAllForms(String infinitive, String pattern, GrammaticalGender grammaticalGender) {
        return wordDao.findAllForms(infinitive, pattern,
                EnumConverter.grammaticalGenderToString(grammaticalGender));
    }

    @Override
    public List<String> findInfinitivesByDeclinedValue(String declinedValue) {
        return wordDao.findInfinitivesByDeclinedValue(declinedValue);
    }

    @Override
    public List<GrammaticalGender> findGrammaticalGenders(String infinitive, String pattern) {
        return wordDao.findGrammaticalGenders(infinitive, pattern);
    }

    @Override
    public List<String> findAllWordsByPatterns(List<String> patterns) {
        SortedSet<String> infinitives = new TreeSet<>();
        for (String pattern : patterns) {
            if (infinitives.isEmpty()) {
                infinitives.addAll(wordDao.findInfinitivesByPattern(pattern));
            } else {
                infinitives.retainAll(wordDao.findInfinitivesByPattern(pattern));
            }
        }
        return new ArrayList<>(infinitives);
    }





    @Override
    public List<Word> findByWordClass(WordClass wordClass) {
        return wordDao.findByWordClass(wordClass);
    }

    @Override
    public List<Word> findByGrammaticalGender(GrammaticalGender grammaticalGender) {
        return wordDao.findByGrammaticalGender(grammaticalGender);
    }

    @Override
    public List<Word> findByNumber(Number number) {
        return wordDao.findByNumber(number);
    }

    @Override
    public List<Word> findByGrammaticalCase(GrammaticalCase grammaticalCase) {
        return wordDao.findByGrammaticalCase(grammaticalCase);
    }
}
