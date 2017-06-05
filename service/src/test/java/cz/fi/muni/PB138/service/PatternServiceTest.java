package cz.fi.muni.PB138.service;

import cz.fi.muni.PB138.dto.PatternDTO;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.service.config.ServiceConfig;
import cz.fi.muni.PB138.service.mappers.PatternMapperService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
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
    public void getPatternByNameTest() throws JAXBException {
        Pattern pattern = patternService.findByName("tetanus");
        PatternDTO patternDTO = patternMapperService.convertToDTO(pattern);
    }

    @Test
    public void getAllPatternsTest(){
        List<Pattern> patterns = patternService.findAllPatterns();
        List<PatternDTO> patternDTOs = patternMapperService.convertToDTO(patterns);
    }

}
