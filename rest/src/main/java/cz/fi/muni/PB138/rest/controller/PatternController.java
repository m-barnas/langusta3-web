package cz.fi.muni.PB138.rest.controller;

import cz.fi.muni.PB138.dto.PatternBaseDTO;
import cz.fi.muni.PB138.dto.PatternDTO;
import cz.fi.muni.PB138.facade.PatternFacade;
import cz.fi.muni.PB138.rest.Uri;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPathExpressionException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 1.6.17.
 *
 * @author Erik Macej 433744
 */

@RestController
@RequestMapping(path = Uri.ROOT_URI_PATTERN, produces = MediaType.APPLICATION_JSON_VALUE)
public class PatternController {

    @Inject
    private PatternFacade patternFacade;

    @RequestMapping(path = "/pattern/{id}", method = RequestMethod.GET)
    public PatternDTO findByName(@PathVariable("id") String name) throws JAXBException, XPathExpressionException {
        return patternFacade.findByName(name);
    }

    @RequestMapping(path = "/findall", method = RequestMethod.GET)
    public List<String> findAllPatterns() throws XPathExpressionException {
        return Collections.unmodifiableList(patternFacade.findAllPatterns());
    }

    @RequestMapping(path = "/patternbase/{id}", method = RequestMethod.GET)
    public PatternBaseDTO findByNameBase(@PathVariable("id") String name) throws JAXBException, XPathExpressionException {
        return patternFacade.findByNameBase(name);
    }

    @RequestMapping(path = "/findallbases", method = RequestMethod.GET)
    public List<PatternBaseDTO> findAllPatternsBases() throws XPathExpressionException, JAXBException {
        return Collections.unmodifiableList(patternFacade.findAllPaternBases());
    }
}
