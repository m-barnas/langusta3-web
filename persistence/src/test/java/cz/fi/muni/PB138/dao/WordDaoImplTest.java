package cz.fi.muni.PB138.dao;

import cz.fi.muni.PB138.entity.Word;
import cz.fi.muni.PB138.enums.GrammaticalCase;
import cz.fi.muni.PB138.enums.GrammaticalGender;
import cz.fi.muni.PB138.enums.Number;
import cz.fi.muni.PB138.enums.WordClass;
import cz.fi.muni.PB138.utils.PersistenceApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Martin on 30.5.2017.
 *
 * @author Martin Barnas 433523
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class WordDaoImplTest extends AbstractTestNGSpringContextTests {

    @Inject
    private WordDao wordDao;

    @PersistenceContext
    private EntityManager em;

    private Word wordNS;
    private Word wordNP;

    @BeforeMethod
    public void init(){

        wordNS = createWord("TEST_WORD", "TEST_PATTERN", "TEST_WORD", WordClass.Noun,
                GrammaticalGender.MasculineAnimate, Number.Singular, GrammaticalCase.Nominative);

        wordNP = createWord("TEST_WORD", "TEST_PATTERN", "TEST_WORD", WordClass.Noun,
                GrammaticalGender.MasculineAnimate, Number.Plural, GrammaticalCase.Nominative);


        wordDao.create(wordNS);
        wordDao.create(wordNP);
    }

    private Word createWord(String infinitive, String pattern, String declinedValue, WordClass wordClass,
                              GrammaticalGender grammaticalGender, Number number,
                              GrammaticalCase grammaticalCase) {
        Word lawyer = new Word();
        lawyer.setInfinitive(infinitive);
        lawyer.setPattern(pattern);
        lawyer.setDeclinedValue(declinedValue);
        lawyer.setWordClass(wordClass);
        lawyer.setGrammaticalGender(grammaticalGender);
        lawyer.setNumber(number);
        lawyer.setGrammaticalCase(grammaticalCase);
        return lawyer;
    }

    private Word createWord(Word word) {
        return createWord(word.getInfinitive(), word.getPattern(), word.getDeclinedValue(), word.getWordClass(),
                word.getGrammaticalGender(), word.getNumber(), word.getGrammaticalCase());
    }

    @Test
    public void createWordTest(){

        Word wordForCreate = createWord("TEST_WORD", "TEST_PATTERN",
                "TEST_WORD", WordClass.Noun, GrammaticalGender.MasculineAnimate,
                Number.Singular, GrammaticalCase.Nominative);

        wordDao.create(wordForCreate);
        Word foundWord = wordDao.findById(wordForCreate.getId());

        assertThat(foundWord.getDeclinedValue()).isEqualTo(wordForCreate.getDeclinedValue());
    }


    @Test
    public void findAllTest(){
        List<Word> loadedWords = wordDao.findAll();

        assertThat(loadedWords).isNotNull();

        assertThat(loadedWords).hasSize(2);

        Word assertWordNS = createWord(wordNS);
        Word assertWordNP = createWord(wordNP);

        assertThat(loadedWords).doesNotContain(assertWordNS);
        assertThat(loadedWords).doesNotContain(assertWordNP);

        assertThat(loadedWords.get(0).getInfinitive()).isEqualTo(assertWordNP.getDeclinedValue());
    }
}
