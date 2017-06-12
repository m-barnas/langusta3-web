package cz.fi.muni.PB138.service;

import cz.fi.muni.PB138.dao.PatternDao;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.PatternBase;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPathExpressionException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 29.5.17.
 *
 * @author Erik Macej 433744
 */
@Service
public class PatternServiceImpl implements PatternService {

    @Inject
    private PatternDao patternDao;

    @Override
    public Pattern findByName(String name) throws JAXBException, XPathExpressionException {
        return patternDao.findByName(name);
    }

    @Override
    public List<String> findAllPatterns() throws XPathExpressionException {
        return Collections.unmodifiableList(patternDao.findAllPatterns());
    }

    @Override
    public PatternBase findByNameBase(String name) throws JAXBException, XPathExpressionException {
        return patternDao.findByNameBase(name);
    }

    @Override
    public List<PatternBase> findAllPaternBases() throws XPathExpressionException, JAXBException {
        return Collections.unmodifiableList(patternDao.findAllPaternBases());
    }
}
