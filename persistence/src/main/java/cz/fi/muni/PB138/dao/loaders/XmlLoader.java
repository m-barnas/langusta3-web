package cz.fi.muni.PB138.dao.loaders;

import cz.fi.muni.PB138.entity.xml.repository.PatternList;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */

@Component
public class XmlLoader {

    private static String PATH_TO_FILE = "cz/fi/muni/PB138/dictionary/src/patterns-k1.xml";

    public static PatternList patternListLoader() throws JAXBException {

        PatternList repository = new PatternList();

        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(PatternList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            repository = (PatternList) jaxbUnmarshaller.unmarshal(
                    new File(XmlLoader.class.getClassLoader()
                            .getResource(PATH_TO_FILE).getFile()));

        }catch (JAXBException ex){
            throw new JAXBException("Fatal error: problem with loading patterns from xml");
        }

        return repository;
    }
}
