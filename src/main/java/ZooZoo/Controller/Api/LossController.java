package ZooZoo.Controller.Api;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LossController {

    private static final String FILENAME = "D:\\intellij-jyb\\Spring_ZooZoo\\src\\main\\resources\\static\\JS\\Api\\lossanimal.xml";

    public static void main(String[] args) {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            // get <staff>
            NodeList list = doc.getElementsByTagName("item");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get staff's attribute
                    String id = element.getAttribute("id");

                    // get text
                    String desertionNo = element.getElementsByTagName("desertionNo").item(0).getTextContent();
                    String filename = element.getElementsByTagName("filename").item(0).getTextContent();
                    String happenDt = element.getElementsByTagName("happenDt").item(0).getTextContent();
                    String happenPlace = element.getElementsByTagName("happenPlace").item(0).getTextContent();
                    String kindCd = element.getElementsByTagName("kindCd").item(0).getTextContent();
                    String noticeNo = element.getElementsByTagName("noticeNo").item(0).getTextContent();
                    String noticeSdt = element.getElementsByTagName("noticeSdt").item(0).getTextContent();
                    String popfile = element.getElementsByTagName("popfile").item(0).getTextContent();
                    String processState = element.getElementsByTagName("processState").item(0).getTextContent();
                    String sexCd = element.getElementsByTagName("sexCd").item(0).getTextContent();
                    String specialMark = element.getElementsByTagName("specialMark").item(0).getTextContent();


                    System.out.println("\nCurrent Element :" + node.getNodeName());
                    System.out.println("유기번호 : " + desertionNo);
                    System.out.println("썸네일 : " + filename);
                    System.out.println("접수일 : " + happenDt);
                    System.out.println("발견장소 : " + happenPlace);
                    System.out.println("품종 : " + kindCd);
                    System.out.println("공고번호 : " + noticeNo);
                    System.out.println("공고일 : " + noticeSdt);
                    System.out.println("이미지 : " + popfile);
                    System.out.println("상태 : " + processState);
                    System.out.println("성별 : " + sexCd);
                    System.out.println("특징 : " + specialMark);

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

}