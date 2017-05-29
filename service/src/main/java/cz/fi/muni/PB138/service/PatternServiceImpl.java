package cz.fi.muni.PB138.service;

import cz.fi.muni.PB138.dao.PatternDao;
import cz.fi.muni.PB138.entity.xml.Pattern;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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
    public Pattern findByName(String name) {
        return patternDao.findByName(name);
    }

    @Override
    public List<Pattern> findAllPatterns() {
        return patternDao.findAllPatterns();
    }
}
