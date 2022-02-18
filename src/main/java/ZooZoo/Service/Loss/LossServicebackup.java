package ZooZoo.Service.Loss;

import ZooZoo.Domain.DTO.Board.LossDTO;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class LossServicebackup {

    // 유기 전체리스트(api 데이터 호출)
    public ArrayList<LossDTO> Losslist() {
        ArrayList<LossDTO> lossDTOS = new ArrayList<>();
        try {
            // max page = 110
            String urlStr = "https://openapi.gg.go.kr/AbdmAnimalProtect?KEY=f116bb9347d04a38a639e01395505d21&pIndex=1&pSize=20";
            // Instantiate the Factory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(urlStr);

            // optional, but recommended
            doc.getDocumentElement().normalize();

            // get <staff>
            NodeList list = doc.getElementsByTagName("row");
            int totalcount = 0;
            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);
                HashMap<String, String> map = new HashMap<String, String>();
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get text
                    String SIGUN_CD = element.getElementsByTagName("SIGUN_CD").item(0).getTextContent();
                    String SIGUN_NM = element.getElementsByTagName("SIGUN_NM").item(0).getTextContent();
                    String ABDM_IDNTFY_NO = element.getElementsByTagName("ABDM_IDNTFY_NO").item(0).getTextContent();
                    String THUMB_IMAGE_COURS = element.getElementsByTagName("THUMB_IMAGE_COURS").item(0).getTextContent();
                    String RECEPT_DE = element.getElementsByTagName("RECEPT_DE").item(0).getTextContent();
                    String DISCVRY_PLC_INFO = element.getElementsByTagName("DISCVRY_PLC_INFO").item(0).getTextContent();
                    String SPECIES_NM = element.getElementsByTagName("SPECIES_NM").item(0).getTextContent();
                    String COLOR_NM = element.getElementsByTagName("COLOR_NM").item(0).getTextContent();
                    String AGE_INFO = element.getElementsByTagName("AGE_INFO").item(0).getTextContent();
                    String BDWGH_INFO = element.getElementsByTagName("BDWGH_INFO").item(0).getTextContent();
                    String PBLANC_IDNTFY_NO = element.getElementsByTagName("PBLANC_IDNTFY_NO").item(0).getTextContent();
                    String PBLANC_BEGIN_DE = element.getElementsByTagName("PBLANC_BEGIN_DE").item(0).getTextContent();
                    String PBLANC_END_DE = element.getElementsByTagName("PBLANC_END_DE").item(0).getTextContent();
                    String IMAGE_COURS = element.getElementsByTagName("IMAGE_COURS").item(0).getTextContent();
                    String STATE_NM = element.getElementsByTagName("STATE_NM").item(0).getTextContent();
                    String SEX_NM = element.getElementsByTagName("SEX_NM").item(0).getTextContent();
                    String NEUT_YN = element.getElementsByTagName("NEUT_YN").item(0).getTextContent();
                    String SFETR_INFO = element.getElementsByTagName("SFETR_INFO").item(0).getTextContent();
                    String SHTER_NM = element.getElementsByTagName("SHTER_NM").item(0).getTextContent();
                    String SHTER_TELNO = element.getElementsByTagName("SHTER_TELNO").item(0).getTextContent();
                    String PROTECT_PLC = element.getElementsByTagName("PROTECT_PLC").item(0).getTextContent();
                    String JURISD_INST_NM = element.getElementsByTagName("JURISD_INST_NM").item(0).getTextContent();
                    String CHRGPSN_NM = element.getElementsByTagName("CHRGPSN_NM").item(0).getTextContent();
                    String CHRGPSN_CONTCT_NO = element.getElementsByTagName("CHRGPSN_CONTCT_NO").item(0).getTextContent();
                    String PARTCLR_MATR = element.getElementsByTagName("PARTCLR_MATR").item(0).getTextContent();
                    String REFINE_LOTNO_ADDR = element.getElementsByTagName("REFINE_LOTNO_ADDR").item(0).getTextContent();
                    String REFINE_ROADNM_ADDR = element.getElementsByTagName("REFINE_ROADNM_ADDR").item(0).getTextContent();
                    String REFINE_ZIP_CD = element.getElementsByTagName("REFINE_ZIP_CD").item(0).getTextContent();
                    String REFINE_WGS84_LOGT = element.getElementsByTagName("REFINE_WGS84_LOGT").item(0).getTextContent();
                    String REFINE_WGS84_LAT = element.getElementsByTagName("REFINE_WGS84_LAT").item(0).getTextContent();

                    // dto에 값 넣기
                    LossDTO lossDTO = LossDTO.builder()
                            .SIGUN_CD(SIGUN_CD)
                            .SIGUN_NM(SIGUN_NM)
                            .ABDM_IDNTFY_NO(ABDM_IDNTFY_NO)
                            .THUMB_IMAGE_COURS(THUMB_IMAGE_COURS)
                            .RECEPT_DE(RECEPT_DE)
                            .DISCVRY_PLC_INFO(DISCVRY_PLC_INFO)
                            .SPECIES_NM(SPECIES_NM)
                            .COLOR_NM(COLOR_NM)
                            .AGE_INFO(AGE_INFO)
                            .BDWGH_INFO(BDWGH_INFO)
                            .PBLANC_IDNTFY_NO(PBLANC_IDNTFY_NO)
                            .PBLANC_BEGIN_DE(PBLANC_BEGIN_DE)
                            .PBLANC_END_DE(PBLANC_END_DE)
                            .IMAGE_COURS(IMAGE_COURS)
                            .STATE_NM(STATE_NM)
                            .SEX_NM(SEX_NM)
                            .NEUT_YN(NEUT_YN)
                            .SFETR_INFO(SFETR_INFO)
                            .SHTER_NM(SHTER_NM)
                            .SHTER_TELNO(SHTER_TELNO)
                            .PROTECT_PLC(PROTECT_PLC)
                            .JURISD_INST_NM(JURISD_INST_NM)
                            .CHRGPSN_NM(CHRGPSN_NM)
                            .CHRGPSN_CONTCT_NO(CHRGPSN_CONTCT_NO)
                            .PARTCLR_MATR(PARTCLR_MATR)
                            .REFINE_LOTNO_ADDR(REFINE_LOTNO_ADDR)
                            .REFINE_ROADNM_ADDR(REFINE_ROADNM_ADDR)
                            .REFINE_ZIP_CD(REFINE_ZIP_CD)
                            .REFINE_WGS84_LOGT(REFINE_WGS84_LOGT)
                            .REFINE_WGS84_LAT(REFINE_WGS84_LAT)
                            .build();
                    lossDTOS.add(lossDTO);
                    totalcount++; // count 1개 +
                }
            }
            System.out.println(totalcount);
            return lossDTOS;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // 유기 상세게시판
    public ArrayList<LossDTO> getlossboard(String ABDM_IDNTFY_NO) {
        ArrayList<LossDTO> lossDTOS = Losslist();
        ArrayList<LossDTO> getlossDTOS = new ArrayList<>();
        for (int i = 0; i < lossDTOS.size(); i++) {
            if (lossDTOS.get(i).getABDM_IDNTFY_NO().equals(ABDM_IDNTFY_NO)) {
                LossDTO lossDTO = LossDTO.builder()
                        .SIGUN_CD(lossDTOS.get(i).getSIGUN_CD())
                        .SIGUN_NM(lossDTOS.get(i).getSIGUN_NM())
                        .ABDM_IDNTFY_NO(lossDTOS.get(i).getABDM_IDNTFY_NO())
                        .THUMB_IMAGE_COURS(lossDTOS.get(i).getTHUMB_IMAGE_COURS())
                        .RECEPT_DE(lossDTOS.get(i).getRECEPT_DE())
                        .DISCVRY_PLC_INFO(lossDTOS.get(i).getDISCVRY_PLC_INFO())
                        .SPECIES_NM(lossDTOS.get(i).getSPECIES_NM())
                        .COLOR_NM(lossDTOS.get(i).getCOLOR_NM())
                        .AGE_INFO(lossDTOS.get(i).getAGE_INFO())
                        .BDWGH_INFO(lossDTOS.get(i).getBDWGH_INFO())
                        .PBLANC_IDNTFY_NO(lossDTOS.get(i).getPBLANC_IDNTFY_NO())
                        .PBLANC_BEGIN_DE(lossDTOS.get(i).getPBLANC_BEGIN_DE())
                        .PBLANC_END_DE(lossDTOS.get(i).getPBLANC_END_DE())
                        .IMAGE_COURS(lossDTOS.get(i).getIMAGE_COURS())
                        .STATE_NM(lossDTOS.get(i).getSTATE_NM())
                        .SEX_NM(lossDTOS.get(i).getSEX_NM())
                        .NEUT_YN(lossDTOS.get(i).getNEUT_YN())
                        .SFETR_INFO(lossDTOS.get(i).getSFETR_INFO())
                        .SHTER_NM(lossDTOS.get(i).getSHTER_NM())
                        .SHTER_TELNO(lossDTOS.get(i).getSHTER_TELNO())
                        .PROTECT_PLC(lossDTOS.get(i).getPROTECT_PLC())
                        .JURISD_INST_NM(lossDTOS.get(i).getJURISD_INST_NM())
                        .CHRGPSN_NM(lossDTOS.get(i).getCHRGPSN_NM())
                        .CHRGPSN_CONTCT_NO(lossDTOS.get(i).getCHRGPSN_CONTCT_NO())
                        .PARTCLR_MATR(lossDTOS.get(i).getPARTCLR_MATR())
                        .REFINE_LOTNO_ADDR(lossDTOS.get(i).getREFINE_LOTNO_ADDR())
                        .REFINE_ROADNM_ADDR(lossDTOS.get(i).getREFINE_ROADNM_ADDR())
                        .REFINE_ZIP_CD(lossDTOS.get(i).getREFINE_ZIP_CD())
                        .REFINE_WGS84_LOGT(lossDTOS.get(i).getREFINE_WGS84_LOGT())
                        .REFINE_WGS84_LAT(lossDTOS.get(i).getREFINE_WGS84_LAT())
                        .build();
                getlossDTOS.add(lossDTO);
            }
        }
        return getlossDTOS;
    }

    // 




}
