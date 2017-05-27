package cz.fi.muni.xml.test;

import cz.fi.muni.PB138.entity.xml.entities.BaseChange;
import cz.fi.muni.PB138.entity.xml.entities.Condition;
import cz.fi.muni.PB138.entity.xml.entities.Form;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Erik Macej 433744 , on 26.5.17.
 *
 * @author Erik Macej 433744
 */
public class XmlUnmarshallingTests {

    @Test
    public void formTest() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Form.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Form form = (Form) jaxbUnmarshaller.unmarshal(
                new File(this.getClass().getClassLoader().getResource("formTest.xml").getFile()) );
    }

    @Test
    public void conditionTest() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Condition.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Condition condition = (Condition) jaxbUnmarshaller.unmarshal(
                new File(this.getClass().getClassLoader().getResource("conditionTest.xml").getFile()) );
    }

    @Test
    public void basechangeTest() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(BaseChange.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        BaseChange baseChange = (BaseChange) jaxbUnmarshaller.unmarshal(
                new File(this.getClass().getClassLoader().getResource("baseChange.xml").getFile()) );
    }
}
