package cz.fi.muni.PB138.service;

import cz.fi.muni.PB138.entity.xml.Pattern;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */
public interface PatternService {

    /**
     * Finds pattern by mame
     *
     * @param name = name of pattern
     * @return pattern with given name
     */
    Pattern findByName(String name);

    /**
     * Finds all patterns
     *
     * @return list of all patterns
     */
    List<Pattern> findAllPatterns();

}
