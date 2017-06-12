package cz.fi.muni.xml.test;

import cz.fi.muni.PB138.dao.PatternDao;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.PatternBase;
import cz.fi.muni.PB138.utils.PersistenceApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPathExpressionException;
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
    public void getPatternByNameTest() throws JAXBException, XPathExpressionException {
        Pattern pattern = patternDao.findByName("tetanus");
    }

    @Test
    public void getAllPatternsTest() throws XPathExpressionException {
        List<String> patterns = patternDao.findAllPatterns();
    }

    @Test
    public void getPatternBaseByNameTest() throws JAXBException, XPathExpressionException {
        PatternBase pattern = patternDao.findByNameBase("tetanus");
    }

    @Test
    public void getAllPatternsBaseTest() throws XPathExpressionException, JAXBException {
        List<PatternBase> patterns = patternDao.findAllPaternBases();
    }
}
