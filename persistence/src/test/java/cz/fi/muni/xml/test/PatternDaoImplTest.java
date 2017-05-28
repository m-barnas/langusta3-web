package cz.fi.muni.xml.test;

import cz.fi.muni.PB138.dao.PatternDao;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.utils.PersistenceApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */

@ContextConfiguration(classes = PersistenceApplicationContext.class)
public class PatternDaoImplTest extends AbstractTestNGSpringContextTests
{

    @Inject
    private PatternDao patternDao;

    @Test
    public void getPatternByNameTest() throws JAXBException {
        Pattern pattern = patternDao.findByName("tetanus");
    }

    @Test
    public void getAllPatternsTest(){
        List<Pattern> patterns = patternDao.findAllPatterns();
    }
}
