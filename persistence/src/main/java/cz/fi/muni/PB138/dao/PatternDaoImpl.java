package cz.fi.muni.PB138.dao;

import cz.fi.muni.PB138.dao.loaders.XmlLoader;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.repository.PatternList;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */

@Repository
public class PatternDaoImpl implements PatternDao {

    private static PatternList repository;

    public PatternDaoImpl() throws JAXBException{
       repository = XmlLoader.patternListLoader();
    }

    @Override
    public Pattern findByName(String name) {
        if(name != null) {
            for (Pattern pattern : repository.getPatternList()) {
                if (name.equals(pattern.getId())) {
                    return pattern;
                }
            }
        }

        return null;
    }

    @Override
    public List<Pattern> findAllPatterns() {
        return Collections.unmodifiableList(repository.getPatternList());
    }
}
