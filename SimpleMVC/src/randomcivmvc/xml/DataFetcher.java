package randomcivmvc.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DataFetcher {
    
    private static final String XSDPATH = "C:\\Users\\X220\\Desktop\\Software projects\\Java\\SimpleMVC\\assests\\xml\\civilizations.xsd";
    private static final String XMLPATH = "C:\\Users\\X220\\Desktop\\Software projects\\Java\\SimpleMVC\\assests\\xml\\civilizations.xml";
    
    private static boolean validateXMLSchema() {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSDPATH));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(XMLPATH)));
        } catch(IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        } catch(SAXException el) {
            System.out.println("SAX Exception: " + el.getMessage());  
            return false;
        }
        
        return true;
    }
    
    public static ArrayList<String> getCivilizations() {
        if(validateXMLSchema()) {
            ArrayList<String> civilizations = new ArrayList<>();
        
            System.out.println("<civilizations.xlm> is valid against <civiliaztions.xsd>");
            try {
                File inputFile = new File(XMLPATH);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("civilization");

                for(int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);

                    if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        String civilization = eElement
                                .getElementsByTagName("name")
                                .item(0)
                                .getTextContent();
                        civilizations.add(civilization);
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
                return civilizations; 
        }
        else {
            System.out.println("Data fetch from <civilizations.xlm> failed.");
            return null;
        }
    }
}
