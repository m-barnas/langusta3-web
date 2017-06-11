package cz.fi.muni.PB138.dao;


import cz.fi.muni.PB138.entity.xml.Pattern;
import cz.fi.muni.PB138.entity.xml.PatternBase;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Erik Macej 433744 , on 28.5.17.
 *
 * @author Erik Macej 433744
 */

@Repository
public class PatternDaoImpl implements PatternDao {

    private Document doc;
    private static String PATH_TO_FILE = "xml/patterns-k1.xml";
    private static String XPATH_FIND_PATTERN_BY_NAME = "//pattern[@id='b1']";

    public PatternDaoImpl() throws JAXBException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {

            builder = factory.newDocumentBuilder();
            doc = builder.parse(
                    PatternDaoImpl.class.getResourceAsStream(PATH_TO_FILE));

        } catch (ParserConfigurationException ex) {

            throw  ex;

        } catch (SAXException ex) {

            throw ex;

        } catch (IOException ex) {

            throw ex;
        }
    }

    @Override
    public Pattern findByName(String name) throws JAXBException, XPathExpressionException {
        try {
            NodeList nodeList = (NodeList) getXPathExpresion("//pattern[@id='" + name + "']")
                    .evaluate(doc, XPathConstants.NODESET);

            return convertNodeListPattern(nodeList);

        } catch (XPathExpressionException ex) {
            throw ex;
        }
    }

    @Override
    public List<String> findAllPatterns() throws XPathExpressionException {

        try {
            NodeList nodeList = (NodeList) getXPathExpresion("//pattern[@id]")
                    .evaluate(doc, XPathConstants.NODESET);

            return Collections.unmodifiableList(extractPatternIds(nodeList));

        } catch (XPathExpressionException ex) {
            throw ex;
        }
    }

    @Override
    public PatternBase findByNameBase(String name) throws JAXBException, XPathExpressionException {
        try {
            NodeList nodeList = (NodeList) getXPathExpresion("//pattern[@id='" + name + "']")
                    .evaluate(doc, XPathConstants.NODESET);

            return convertNodeListBase(nodeList);

        } catch (XPathExpressionException ex) {
            throw ex;
        }
    }

    @Override
    public List<PatternBase> findAllPaternBases() throws XPathExpressionException, JAXBException {
        try {
            NodeList nodeList = (NodeList) getXPathExpresion("//pattern")
                    .evaluate(doc, XPathConstants.NODESET);

            return Collections.unmodifiableList(convertToPatternBases(nodeList));

        } catch (XPathExpressionException ex) {
            throw ex;
        }
    }

    private XPathExpression getXPathExpresion(String expr) throws XPathExpressionException {
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        try {
            return xpath.compile(expr);
        } catch (XPathExpressionException ex) {
            throw ex;
        }
    }

    private Pattern convertNodeListPattern(NodeList nodeList) throws JAXBException {

        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Pattern.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (Pattern) jaxbUnmarshaller.unmarshal(nodeList.item(0));

        }catch (JAXBException ex){
            throw ex;
        }
    }

    private PatternBase convertNodeListBase(NodeList nodeList) throws JAXBException {

        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(PatternBase.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (PatternBase) jaxbUnmarshaller.unmarshal(nodeList.item(0));

        }catch (JAXBException ex){
            throw ex;
        }
    }

    private List<PatternBase> convertToPatternBases(NodeList nodelist) throws JAXBException {

        List<PatternBase> patternBases = new ArrayList<>();

        for (int i = 0; i < nodelist.getLength(); i++)
        {
            patternBases.add(convertToPatternBase(nodelist.item(i)));
        }

        return Collections.unmodifiableList(patternBases);
    }

    private PatternBase convertToPatternBase(Node node) throws JAXBException {

        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(PatternBase.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (PatternBase) jaxbUnmarshaller.unmarshal(node);

        }catch (JAXBException ex){
            throw ex;
        }

    }

    private List<String> extractPatternIds(NodeList nodelist){

        List<String> result = new ArrayList<>();

        for (int i = 0; i < nodelist.getLength(); i++)
        {
            Node currentItem = nodelist.item(i);
            result.add(currentItem.getAttributes().getNamedItem("id").getNodeValue());
        }

        return result;
    }
}
