package Utilities.Reader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class DataReaderManager {

    public static String appConfigXmlPath = System.getProperty("user.dir") + "/src/main/resources/appConfig.xml";

    public static Properties data(String fileName) {
        return loadProperties(System.getProperty("user.dir") + "//src//main//java//properties//" + fileName + ".properties");
    }

    private static Properties loadProperties(String path) {
        Properties pro = new Properties();
        try {
            Reader stream =
                    new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
            pro.load(stream);
        } catch (IOException e) {
            System.out.println("Error occurred :" + e.getMessage());
        }
        return pro;
    }


    public static String getValue(String fileName, String keyWord) {
        return data(fileName).getProperty(keyWord);
    }

    /***
     * @description this method will be used to read config xml files which will be
     *              consumed by the framework. Values like OTP, Browser name, etc
     *              will be stored in this xml.
     * @param parentAttrName- Name of the attribute for which you need the value.
     * @return Value of the attribute name.
     * @throws Exception
     */
    public static String readConfigXml(String parentAttrName) {
        String Configdata = null;
        try {

            File fXmlFile = new File(appConfigXmlPath);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("PublicVariable");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("name").equalsIgnoreCase(parentAttrName.trim())) {
                        Configdata = eElement.getElementsByTagName("name").item(0).getTextContent();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Configdata == null) {
            System.out.println("Tag/Element is Empty >>> " + parentAttrName);
        }
        return Configdata.trim();
    }
}
