package cz.fi.muni.PB138.rest.controller;

import cz.fi.muni.PB138.dto.PatternDTO;
import cz.fi.muni.PB138.facade.PatternFacade;
import cz.fi.muni.PB138.rest.Uri;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
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

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public PatternDTO findByName(@PathVariable("id") String name){
        return patternFacade.findByName(name);
    }

    @RequestMapping(path = "/findall", method = RequestMethod.GET)
    public List<PatternDTO> findAllPatterns(){
        return Collections.unmodifiableList(patternFacade.findAllPatterns());
    }
}
