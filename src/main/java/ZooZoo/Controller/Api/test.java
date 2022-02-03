package ZooZoo.Controller.Api;

import ZooZoo.Domain.DTO.Board.LossDTO;
import ZooZoo.Service.Loss.LossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping
public class test {

    @Autowired
    LossService lossService;

    @GetMapping("/lossapi")
    public String Loss(Model model){
        LossDTO lossDTO = new LossDTO();

        StringBuilder result = new StringBuilder();
        ArrayList<HashMap<String, String>> lossList = new ArrayList<HashMap<String, String>>();
        try {
            // max page = 110
            String urlStr = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20140301&endde=20140430&pageNo=1&numOfRows=110&ServiceKey=1LB54yX2%2BHgedpJ5WPtUlCgis3Wj3ulEoeJorsRTkrxmbfRPO21aodfkeLX%2BJ5UUM8nOZdSDoY18dKpdd6shAA%3D%3D";
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
                HashMap<String, String> map = new HashMap<String, String>();
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get text
                    map.put("age", element.getElementsByTagName("age").item(0).getTextContent());
                    map.put("careAddr", element.getElementsByTagName("careAddr").item(0).getTextContent());
                    map.put("careNm",element.getElementsByTagName("careNm").item(0).getTextContent());
                    map.put("careTel", element.getElementsByTagName("careTel").item(0).getTextContent());
                    map.put("chargeNm", element.getElementsByTagName("chargeNm").item(0).getTextContent());
                    map.put("colorCd", element.getElementsByTagName("colorCd").item(0).getTextContent());
                    map.put("desertionNo", element.getElementsByTagName("desertionNo").item(0).getTextContent());
                    map.put("filename", element.getElementsByTagName("filename").item(0).getTextContent());
                    map.put("happenDt", element.getElementsByTagName("happenDt").item(0).getTextContent());
                    map.put("happenPlace", element.getElementsByTagName("happenPlace").item(0).getTextContent());
                    map.put("kindCd", element.getElementsByTagName("kindCd").item(0).getTextContent());
                    map.put("neuterYn", element.getElementsByTagName("neuterYn").item(0).getTextContent());
                    map.put("noticeEdt", element.getElementsByTagName("noticeEdt").item(0).getTextContent());
                    map.put("noticeNo", element.getElementsByTagName("noticeNo").item(0).getTextContent());
                    map.put("noticeSdt", element.getElementsByTagName("noticeSdt").item(0).getTextContent());
                    map.put("officetel", element.getElementsByTagName("officetel").item(0).getTextContent());
                    map.put("orgNm", element.getElementsByTagName("orgNm").item(0).getTextContent());
                    map.put("popfile", element.getElementsByTagName("popfile").item(0).getTextContent());
                    map.put("processState", element.getElementsByTagName("processState").item(0).getTextContent());
                    map.put("sexCd", element.getElementsByTagName("sexCd").item(0).getTextContent());
                    map.put("specialMark", element.getElementsByTagName("specialMark").item(0).getTextContent());
                    map.put("weight", element.getElementsByTagName("weight").item(0).getTextContent());

                    lossList.add(map);
                }
            }
            model.addAttribute("loss", lossList);
            System.out.println(lossList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Board/Loss/test";
    }

}
