package cz.fi.muni.PB138.service;

import cz.fi.muni.PB138.dto.PatternBaseDTO;
import cz.fi.muni.PB138.dto.PatternDTO;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.PatternBase;
import cz.fi.muni.PB138.service.config.ServiceConfig;
import cz.fi.muni.PB138.service.mappers.PatternMapperService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPathExpressionException;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */

@ContextConfiguration(classes = ServiceConfig.class)
public class PatternServiceTest extends AbstractTestNGSpringContextTests {
  
    @Inject
    private PatternService patternService;

    @Inject
    private PatternMapperService patternMapperService;

    @Test
    public void getPatternByNameTest() throws JAXBException, XPathExpressionException {
        Pattern pattern = patternService.findByName("tetanus");
        PatternDTO patternDTO = patternMapperService.convertToDTO(pattern);
    }

    @Test
    public void getAllPatternsTest() throws XPathExpressionException {
        List<String> patterns = patternService.findAllPatterns();
    }

    @Test
    public void getPatternByNameTestBase() throws JAXBException, XPathExpressionException {
        PatternBase pattern = patternService.findByNameBase("tetanus");
        PatternBaseDTO patternDTO = patternMapperService.convertToDTO(pattern);
    }

    @Test
    public void getAllPatternsTestBases() throws XPathExpressionException, JAXBException {
        List<PatternBase> patterns = patternService.findAllPaternBases();
        List<PatternBaseDTO> patternBaseDTOs = patternMapperService.convertToDTO(patterns);
    }
}
