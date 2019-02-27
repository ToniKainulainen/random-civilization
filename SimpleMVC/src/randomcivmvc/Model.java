package randomcivmvc;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.ArrayList;
import randomcivmvc.xml.DataFetcher;

public class Model {

    private final ArrayList<String> civilizations;
    
    public Model() {
        civilizations = DataFetcher.getCivilizations();
    }
    
    public String civ() {
        int civIndex = (int) (Math.random() * 27);
        // in case, if you are REALLY lucky and get 1.0 from Math.random()
        civIndex = (civIndex == 27) ? 26 : civIndex; 
                             
        return civilization(civilizations, civIndex);  
    }
    
    private String civilization(ArrayList<String> stringArr, int index) {
        return stringArr.get(index);
    }  
    
}
