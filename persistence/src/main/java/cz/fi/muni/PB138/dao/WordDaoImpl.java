package cz.fi.muni.PB138.dao;

import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.WordClass;
import cz.fi.muni.PB138.repository.WordRepository;
import cz.fi.muni.PB138.utils.WordConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static cz.fi.muni.PB138.specifications.WordSpecifications.isNotPresentInInfinitives;
import static cz.fi.muni.PB138.specifications.WordSpecifications.isNotRepresentedByPattern;
import static org.springframework.data.jpa.domain.Specifications.where;

/**
 * Created by Martin on 26.5.2017.
 *
 * @author Martin Barnas 433523
 */
@Repository
public class WordDaoImpl implements WordDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private WordRepository wordRepository;

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
    public List<String> findInfinitivesByPattern(String pattern) {
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
                        "WHERE lower(w.declinedValue) = lower(:declinedValue) " +
                        "AND w.pattern IS NOT NULL "
                , String.class)
                .setParameter("declinedValue", declinedValue)
                .getResultList();
    }

    @Override
    public List<String> findPatternsByInfinitive(String infinitive) {
        return em.createQuery(
                "SELECT DISTINCT w.pattern FROM Word w " +
                        "WHERE lower(w.infinitive) = lower(:infinitive) " +
                        "AND w.pattern IS NOT NULL "
                , String.class)
                .setParameter("infinitive", infinitive)
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
    public List<Word> findAllForms(String infinitive, String pattern, String grammaticalGender) {
        return em.createQuery(
                "SELECT w FROM Word w " +
                        "WHERE lower(w.infinitive) = lower(:infinitive)" +
                        "AND lower(w.pattern) = lower(:pattern) " +
                        "AND lower(w.grammaticalGender) = lower(:grammaticalGender)"
                , Word.class)
                .setParameter("infinitive", infinitive)
                .setParameter("pattern", pattern)
                .setParameter("grammaticalGender", grammaticalGender)
                .getResultList();
    }

    @Override
    public List<String> findInfinitivesByDeclinedValue(String declinedValue) {
        return em.createQuery(
                "SELECT DISTINCT w.infinitive FROM Word w " +
                        "WHERE lower(w.declinedValue) = lower(:declinedValue) "
                , String.class)
                .setParameter("declinedValue", declinedValue)
                .getResultList();
    }

    @Override
    public List<GrammaticalGender> findGrammaticalGenders(String infinitive, String pattern) {
        return em.createQuery(
                "SELECT DISTINCT w.grammaticalGender FROM Word w " +
                        "WHERE lower(w.infinitive) = lower(:infinitive) " +
                        "AND lower(w.pattern) = lower(:pattern) " +
                        "AND w.grammaticalGender IS NOT NULL "
                , GrammaticalGender.class)
                .setParameter("infinitive", infinitive)
                .setParameter("pattern", pattern)
                .getResultList();
    }

    @Override
    public SortedSet<Word> findAllWordsByPatterns(List<String> patterns) {
        Specifications<Word> specifications = null;
        for (String p : patterns) {
            if(specifications == null) {
                specifications = where(isNotRepresentedByPattern(p));
            } else {
                specifications = specifications.or(isNotRepresentedByPattern(p));
            }
        }
        return new TreeSet<Word>(wordRepository
                .findAll(isNotPresentInInfinitives(WordConverter.wordToInfinitive(new TreeSet<>(wordRepository
                        .findAll(specifications))))));
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
