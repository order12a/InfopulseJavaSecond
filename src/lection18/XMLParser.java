package lection18;

import oracle.xml.parser.v2.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
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
import java.util.List;


public class XMLParser {
    static Document doc;
    static NodeList nList;
    static Node node;

    static DOMParser domParser;
    static Document domDocument;
    private static List<Name> operators;

    public static void readDocumentFromXmlDOMFile(String pathToFile) {

        FileSystem fileSystem = FileSystems.getDefault();
        String sep = fileSystem.getSeparator();
        String newPath = "";

        try {
            newPath = pathToFile.replaceAll("\\\\", sep);
        } catch (Exception e) {
        }
        try {
            newPath = newPath.replaceAll("/", sep);
        } catch (Exception e2) {
        }

        File fXmlFile = new File(newPath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            doc = dBuilder.parse(fXmlFile);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printNode(doc, "");
        System.out.println("\n");

//        domParser = new DOMParser();
//        try {
//            // установка способов проверки с использованием XSD
//            domParser.setValidationMode(DOMParser.SCHEMA_VALIDATION);
//            domParser.parse(String.valueOf(fXmlFile));
//            // Obtain the document
//            domDocument = domParser.getDocument();
//        } catch (SAXNotRecognizedException e) {
//            e.printStackTrace();
//            System.out.print("идентификатор не распознан");
//        } catch (SAXNotSupportedException e) {
//            e.printStackTrace();
//            System.out.print("неподдерживаемая операция");
//        } catch (SAXException e) {
//            e.printStackTrace();
//            System.out.print("глобальная SAX ошибка ");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.print("ошибка I/O потока");
//        }
//        System.out.println("проверка " + newPath + " завершена");
        // Print the document from the DOM tree
    }

    public static void printNode(Node node, String indent) {

        switch (node.getNodeType()) {

            case Node.DOCUMENT_NODE:
                System.out.println("<xml version=\"1.0\">\n");
                // recurse on each child
                NodeList nodes = node.getChildNodes();
                if (nodes != null) {
                    for (int i = 0; i < nodes.getLength(); i++) {


                        printNode(nodes.item(i), "");
                    }
                }
                break;

            case Node.ELEMENT_NODE:
                String name = node.getNodeName();
                System.out.print(indent + "<" + name);
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node current = attributes.item(i);
                    System.out.print(" " + current.getNodeName() + "=\""
                            + current.getNodeValue() + "\"");
                }
                System.out.print(">");

                // recurse on each child
                NodeList children = node.getChildNodes();
                if (children != null) {
                    for (int i = 0; i < children.getLength(); i++) {
                        printNode(children.item(i), indent + "  ");
                    }
                }

                System.out.print("</" + name + ">");
                break;

            case Node.TEXT_NODE:
                System.out.print(node.getNodeValue());
                break;
        }

    }

}
