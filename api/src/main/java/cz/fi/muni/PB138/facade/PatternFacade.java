package cz.fi.muni.PB138.facade;

import cz.fi.muni.PB138.dto.PatternDTO;

import java.util.List;

/**
 * Created by Erik Macej 433744 , on 30.5.17.
 *
 * @author Erik Macej 433744
 */
public interface PatternFacade {

    /**
     * Finds pattern by mame
     *
     * @param name = name of pattern
     * @return pattern with given name
     */
    PatternDTO findByName(String name);

    /**
     * Finds all patterns
     *
     * @return list of all patterns
     */
    List<PatternDTO> findAllPatterns();
}
