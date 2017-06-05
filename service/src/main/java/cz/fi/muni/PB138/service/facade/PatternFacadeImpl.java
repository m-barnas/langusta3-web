package cz.fi.muni.PB138.service.facade;

import cz.fi.muni.PB138.dto.PatternDTO;
import cz.fi.muni.PB138.facade.PatternFacade;
import cz.fi.muni.PB138.service.PatternService;
import cz.fi.muni.PB138.service.mappers.PatternMapperService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
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
    public PatternDTO findByName(String name) {
        return patternMapperService.convertToDTO(patternService.findByName(name));
    }

    @Override
    public List<PatternDTO> findAllPatterns() {
        return Collections.unmodifiableList(
                patternMapperService.convertToDTO(patternService.findAllPatterns()));
    }
}
