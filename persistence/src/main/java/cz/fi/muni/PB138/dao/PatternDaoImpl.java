package cz.fi.muni.PB138.dao;

import cz.fi.muni.PB138.dao.loaders.XmlLoader;
import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.repository.PatternList;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */

@Repository
public class PatternDaoImpl implements PatternDao {

    private static String PATH_TO_FILE = "cz/fi/muni/PB138/dictionary/src/patterns-k1.xml";
    private static PatternList repository;

    public PatternDaoImpl() throws JAXBException{
        this.repository = XmlLoader.patternListLoader();
    }

    @Override
    public Pattern findByName(String name) throws JAXBException {
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
        return repository.getPatternList();
    }
}
