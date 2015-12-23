package lection18;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class TestDataHelper{

	static Document doc;
	static NodeList nList;
	static Node node;
	
	public static void readTargetFile(String path) throws ParserConfigurationException, SAXException, IOException {
		FileSystem fileSystem = FileSystems.getDefault();
		String sep = fileSystem.getSeparator();
		String newPath = "";
		
		try {
			newPath = path.replaceAll("\\\\", sep);
		} catch (Exception e) {
		}	
		
		try {
			newPath = newPath.replaceAll("/", sep);
		} catch (Exception e2) {
		}

		File fXmlFile = new File(newPath);
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    doc = dBuilder.parse(fXmlFile);
	    
	}
	
//	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//		readTargetFile("src/resources/Testdata/TestData.xml");
//		parseProvider("buyer_user");
//		System.out.println("\nReturn by key - " + getData("login"));
//	}
	
	public static void parseProvider(String provider) {
		doc.getDocumentElement().normalize();
		if (PropertyLoader.loadProperty("env").contains(".com")) {
			String prodProvider = provider + "_prod";
			nList = doc.getElementsByTagName(prodProvider);
		} else {
			nList = doc.getElementsByTagName(provider);
		}
		System.out.println("----------testData------------------");
	}
	
	public static String getData(String key) {

		 String value = "";
		    for (int temp = 0; temp < nList.getLength(); temp++) {

		        Node nNode = nList.item(temp);
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

		            Element eElement = (Element) nNode;
		            value = eElement.getElementsByTagName(key).item(0).getTextContent();
		            System.out.println(key + ": " + value);
		        }else {

				}
		    }
		    
		return value;
	}
}
