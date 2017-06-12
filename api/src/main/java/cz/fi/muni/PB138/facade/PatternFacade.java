package cz.fi.muni.PB138.facade;

import cz.fi.muni.PB138.dto.PatternBaseDTO;
import cz.fi.muni.PB138.dto.PatternDTO;

import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPathExpressionException;
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
    PatternDTO findByName(String name) throws JAXBException, XPathExpressionException;

    /**
     * Finds all patterns names
     *
     * @return list of all patterns names
     */
    List<String> findAllPatterns() throws XPathExpressionException;

    /**
     * Find pattern by name
     *
     * @param name = name of pattern
     * @return base info about pattern
     */
    PatternBaseDTO findByNameBase(String name) throws JAXBException, XPathExpressionException;

    /**
     * Find all pattern bases
     *
     * @return pattern bases
     */
    List<PatternBaseDTO> findAllPaternBases() throws XPathExpressionException, JAXBException;

}
