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

    public static void main(String[] args) {

        try {
            String urlStr = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20140301&endde=20140430&pageNo=1&numOfRows=120&ServiceKey=1LB54yX2%2BHgedpJ5WPtUlCgis3Wj3ulEoeJorsRTkrxmbfRPO21aodfkeLX%2BJ5UUM8nOZdSDoY18dKpdd6shAA%3D%3D";
            // Instantiate the Factory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(urlStr);

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
                    String age = element.getElementsByTagName("age").item(0).getTextContent();
                    String careAddr = element.getElementsByTagName("careAddr").item(0).getTextContent();
                    String careNm = element.getElementsByTagName("careNm").item(0).getTextContent();
                    String careTel = element.getElementsByTagName("careTel").item(0).getTextContent();
                    String chargeNm = element.getElementsByTagName("chargeNm").item(0).getTextContent();
                    String colorCd = element.getElementsByTagName("colorCd").item(0).getTextContent();
                    String desertionNo = element.getElementsByTagName("desertionNo").item(0).getTextContent();
                    String filename = element.getElementsByTagName("filename").item(0).getTextContent();
                    String happenDt = element.getElementsByTagName("happenDt").item(0).getTextContent();
                    String happenPlace = element.getElementsByTagName("happenPlace").item(0).getTextContent();
                    String kindCd = element.getElementsByTagName("kindCd").item(0).getTextContent();
                    String neuterYn = element.getElementsByTagName("neuterYn").item(0).getTextContent();
                    String noticeEdt = element.getElementsByTagName("noticeEdt").item(0).getTextContent();
                    String noticeNo = element.getElementsByTagName("noticeNo").item(0).getTextContent();
                    String noticeSdt = element.getElementsByTagName("noticeSdt").item(0).getTextContent();
                    String officetel = element.getElementsByTagName("officetel").item(0).getTextContent();
                    String orgNm = element.getElementsByTagName("orgNm").item(0).getTextContent();
                    String popfile = element.getElementsByTagName("popfile").item(0).getTextContent();
                    String processState = element.getElementsByTagName("processState").item(0).getTextContent();
                    String sexCd = element.getElementsByTagName("sexCd").item(0).getTextContent();
                    String specialMark = element.getElementsByTagName("specialMark").item(0).getTextContent();
                    String weight = element.getElementsByTagName("weight").item(0).getTextContent();


                    System.out.println("\nNo : " + (temp + 1));
                    System.out.println("공고종료일 : " + noticeEdt);
                    System.out.println("Image : " + popfile);
                    System.out.println("상태 : " + processState);
                    System.out.println("성별 : " + sexCd);
                    System.out.println("중성화여부 : " + neuterYn);
                    System.out.println("특징 : " + specialMark);
                    System.out.println("보호소이름 : " + careNm);
                    System.out.println("보호소전화번호 : " + careTel);
                    System.out.println("보호장소 : " + careAddr);
                    System.out.println("관할기관 : " + orgNm);
                    System.out.println("담당자 : " + chargeNm);
                    System.out.println("담당자연락처 : " + officetel);
                    System.out.println("유기번호 : " + desertionNo);
                    System.out.println("Thumbnail Image : " + filename);
                    System.out.println("접수일 : " + happenDt);
                    System.out.println("발견장소 : " + happenPlace);
                    System.out.println("품종 : " + kindCd);
                    System.out.println("색상 : " + colorCd);
                    System.out.println("나이 : " + age);
                    System.out.println("체중 : " + weight);
                    System.out.println("공고번호 : " + noticeNo);
                    System.out.println("공고시작일 : " + noticeSdt);

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

}
