package cz.fi.muni.PB138.dao;

import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.WordClass;
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
        return em.createQuery(
                "SELECT w FROM Word w"
                , Word.class)
                .getResultList();
    }

    @Override
    public List<String> findInfinitives(String pattern) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.pattern) = lower(:pattern) " +
                        "GROUP BY w.infinitive"
                , String.class)
                .setParameter("pattern", pattern)
                .getResultList();
    }

    @Override
    public List<String> findByNumberOfPatterns(Long numberOfPatterns) {
        return em.createQuery(
                "SELECT w.infinitive FROM Word w " +
                        "GROUP BY w.infinitive " +
                        "HAVING count(DISTINCT w.pattern) = :numberOfPatterns"
                , String.class)
                .setParameter("numberOfPatterns", numberOfPatterns)
                .getResultList();
    }

    @Override
    public List<String> findPatterns(String declinedValue) {
        return em.createQuery(
                "SELECT DISTINCT w.pattern FROM Word w " +
                        "WHERE lower(w.declinedValue) = lower(:declinedValue)"
                , String.class)
                .setParameter("declinedValue", declinedValue)
                .getResultList();
    }

    @Override
    public List<Word> findByDeclinedValue(String declinedValue) {
        return em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.declinedValue) LIKE lower(:declinedValue)"
                , Word.class)
                .setParameter("declinedValue", declinedValue)
                .getResultList();
    }

    @Override
    public List<Word> findAllForms(String infinitive, String pattern) {
        return em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.infinitive) = lower(:infinitive)" +
                        "AND lower(w.pattern) = lower(:pattern)"
                , Word.class)
                .setParameter("infinitive", infinitive)
                .setParameter("pattern", pattern)
                .getResultList();
    }






    @Override
    public List<Word> findByWordClass(WordClass wordClass) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.wordClass) = lower(:wordClass) "
                , Word.class)
                .setParameter("wordClass", wordClass)
                .getResultList();
    }

    @Override
    public List<Word> findByGrammaticalGender(GrammaticalGender grammaticalGender) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.grammaticalGender) = lower(:grammaticalGender) "
                , Word.class)
                .setParameter("grammaticalGender", grammaticalGender)
                .getResultList();
    }

    @Override
    public List<Word> findByNumber(Number number) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.number) = lower(:number) "
                , Word.class)
                .setParameter("number", number)
                .getResultList();
    }

    @Override
    public List<Word> findByGrammaticalCase(GrammaticalCase grammaticalCase) {
        return em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.grammaticalCase) = lower(:grammaticalCase)"
                , Word.class)
                .setParameter("grammaticalCase", grammaticalCase)
                .getResultList();
    }
}
