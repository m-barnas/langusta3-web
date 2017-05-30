package cz.fi.muni.PB138.dao;

import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Martin on 26.5.2017.
 *
 * @author Martin Barnas 433523
 */
@Repository
public class WordDaoImpl implements WordDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Word word) {
        em.persist(word);
    }

    @Override
    public Word findById(Long id) {
        return em.find(Word.class, id);
    }

    @Override
    public List<Word> findAll() {
        return em.createQuery("SELECT w FROM Word w"
                , Word.class).getResultList();
    }

    @Override
    public List<Word> findByInfinitive(String infinitive) {
        List<Word> words = em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.infinitive) LIKE lower(:infinitive)", Word.class)
                .setParameter("infinitive", infinitive)
                .getResultList();
        return words.isEmpty() ? null : words;
    }

    @Override
    public List<Word> findWordsByPattern(String pattern) {
        List<Word> words = em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.pattern) LIKE lower(:pattern) " +
                        "AND lower(w.grammaticalCase) LIKE 'nominative'"
                ,Word.class)
                .setParameter("pattern", pattern)
                .getResultList();
        return words.isEmpty() ? null : words;
    }

    @Override
    public List<Word> findByDeclinedValue(String declinedValue) {
        List<Word> words = em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.declinedValue) LIKE lower(:declinedValue)", Word.class)
                .setParameter("declinedValue", declinedValue)
                .getResultList();
        return words.isEmpty() ? null : words;
    }

    @Override
    public List<Word> findByWordClass(String wordClass) {
        List<Word> words = em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.wordClass) LIKE lower(:wordClass) " +
                        "AND lower(w.grammaticalCase) LIKE 'nominative'"
                ,Word.class)
                .setParameter("wordClass", wordClass)
                .getResultList();
        return words.isEmpty() ? null : words;
    }

    @Override
    public List<Word> findByGrammaticalGender(GrammaticalGender grammaticalGender) {
        List<Word> words = em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.grammaticalGender) LIKE lower(:grammaticalGender) " +
                        "AND lower(w.grammaticalCase) LIKE 'nominative'"
                ,Word.class)
                .setParameter("grammaticalGender", grammaticalGender)
                .getResultList();
        return words.isEmpty() ? null : words;
    }

    @Override
    public List<Word> findByNumber(Number number) {
        List<Word> words = em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.number) LIKE lower(:number) " +
                        "AND lower(w.grammaticalCase) LIKE 'nominative'"
                ,Word.class)
                .setParameter("number", number)
                .getResultList();
        return words.isEmpty() ? null : words;
    }

    @Override
    public List<Word> findByGrammaticalCase(GrammaticalCase grammaticalCase) {
        List<Word> words = em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.grammaticalCase) LIKE lower(:grammaticalCase)", Word.class)
                .setParameter("grammaticalCase", grammaticalCase)
                .getResultList();
        return words.isEmpty() ? null : words;
    }

    @Override
    public List<Word> findByNumberOfPattern(int numberOfPatterns) {
        List<Word> words = em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.grammaticalCase) = 'nominative' " +
                        "GROUP BY w.pattern " +
                        "HAVING count(w.pattern) = :numberOfPatterns", Word.class)
                .setParameter("numberOfPatterns", numberOfPatterns)
                .getResultList();
        return words.isEmpty() ? null : words;
    }
}
