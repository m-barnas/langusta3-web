package cz.fi.muni.PB138.service.facade;

import cz.fi.muni.PB138.dto.PatternBaseDTO;
import cz.fi.muni.PB138.dto.PatternDTO;
import cz.fi.muni.PB138.facade.PatternFacade;
import cz.fi.muni.PB138.service.PatternService;
import cz.fi.muni.PB138.service.mappers.PatternMapperService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPathExpressionException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 31.5.17.
 *
 * @author Erik Macej 433744
 */

@Service
public class PatternFacadeImpl implements PatternFacade {

    @Inject
    private PatternService patternService;

    @Inject
    private PatternMapperService patternMapperService;


    @Override
    public PatternDTO findByName(String name) throws JAXBException, XPathExpressionException {
        return patternMapperService.convertToDTO(patternService.findByName(name));
    }

    @Override
    public List<String> findAllPatterns() throws XPathExpressionException {
        return Collections.unmodifiableList(patternService.findAllPatterns());
    }

    @Override
    public PatternBaseDTO findByNameBase(String name) throws JAXBException, XPathExpressionException {
        return patternMapperService.convertToDTO(patternService.findByNameBase(name));
    }

    @Override
    public List<PatternBaseDTO> findAllPaternBases() throws XPathExpressionException, JAXBException {
        return Collections.unmodifiableList(
                patternMapperService.convertToDTO(patternService.findAllPaternBases()));
    }
}
