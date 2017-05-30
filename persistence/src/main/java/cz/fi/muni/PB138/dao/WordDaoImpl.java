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
        return em.createQuery("SELECT w FROM Word w",
                Word.class)
                .getResultList();
    }

    @Override
    public List<Word> findByInfinitive(String infinitive) {
        return em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.infinitive) = lower(:infinitive)",
                Word.class)
                .setParameter("infinitive", infinitive)
                .getResultList();
    }

    @Override
    public List<Word> findWordsByPattern(String pattern) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.pattern) = lower(:pattern) "
                ,Word.class)
                .setParameter("pattern", pattern)
                .getResultList();
    }

    @Override
    public List<Word> findByDeclinedValue(String declinedValue) {
        return em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.declinedValue) LIKE lower(:declinedValue)",
                Word.class)
                .setParameter("declinedValue", declinedValue)
                .getResultList();
    }

    @Override
    public List<Word> findByWordClass(String wordClass) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.wordClass) = lower(:wordClass) "
                ,Word.class)
                .setParameter("wordClass", wordClass)
                .getResultList();
    }

    @Override
    public List<Word> findByGrammaticalGender(GrammaticalGender grammaticalGender) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.grammaticalGender) = lower(:grammaticalGender) "
                ,Word.class)
                .setParameter("grammaticalGender", grammaticalGender)
                .getResultList();
    }

    @Override
    public List<Word> findByNumber(Number number) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.number) = lower(:number) "
                ,Word.class)
                .setParameter("number", number)
                .getResultList();
    }

    @Override
    public List<Word> findByGrammaticalCase(GrammaticalCase grammaticalCase) {
        return em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.grammaticalCase) = lower(:grammaticalCase)",
                Word.class)
                .setParameter("grammaticalCase", grammaticalCase)
                .getResultList();
    }

    @Override
    public List<Word> findByNumberOfPattern(int numberOfPatterns) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "GROUP BY w.pattern " +
                        "HAVING count(w.pattern) = :numberOfPatterns",
                Word.class)
                .setParameter("numberOfPatterns", numberOfPatterns)
                .getResultList();
    }
}
