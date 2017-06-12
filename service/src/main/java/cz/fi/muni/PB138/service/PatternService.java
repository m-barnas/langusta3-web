package cz.fi.muni.PB138.service;

import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.PatternBase;

import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPathExpressionException;
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
    Pattern findByName(String name) throws JAXBException, XPathExpressionException;

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
    PatternBase findByNameBase(String name) throws JAXBException, XPathExpressionException;

    /**
     * Find all pattern bases
     *
     * @return pattern bases
     */
    List<PatternBase> findAllPaternBases() throws XPathExpressionException, JAXBException;
}
