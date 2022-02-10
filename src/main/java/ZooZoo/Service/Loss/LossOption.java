package ZooZoo.Service.Loss;

import ZooZoo.Domain.DTO.Board.LossDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LossOption {

    // 옵션 - 성별
    public ArrayList<LossDTO> sexlist(String sex, String kind, String city) {
        LossService lossService = new LossService();
        ArrayList<LossDTO> totLosslist = lossService.totlosslist(); // 전체 리스트
        ArrayList<LossDTO> lossDTOS = new ArrayList<>();
        try {
            if ((sex == null && kind == null && city == null) || (sex.equals("total") && kind.equals("total") && city.equals("total"))) {
                return totLosslist;
            }
            for (int i = 0; i < totLosslist.size(); i++) {
                // 전체 조건 검색
                if (sex != null && kind != null && city != null && totLosslist.get(i).getSEX_NM().equals(sex) && totLosslist.get(i).getSPECIES_NM().equals(kind) && totLosslist.get(i).getCity().equals(city)) {
                    lossDTOS.add(totLosslist.get(i));
                // 성별만 total
                } else if((sex == null || sex.equals("total")) && kind != null && totLosslist.get(i).getSPECIES_NM().equals(kind) && city != null && totLosslist.get(i).getCity().equals(city)) {
                    lossDTOS.add(totLosslist.get(i));
                // 종류만 total
                } else if((kind == null || kind.equals("total")) && sex != null && totLosslist.get(i).getSEX_NM().equals(sex) && city != null && totLosslist.get(i).getCity().equals(city)) {
                    lossDTOS.add(totLosslist.get(i));
                // 시군구만 total
                } else if((city == null || city.equals("total")) && sex != null && totLosslist.get(i).getSEX_NM().equals(sex) && kind != null && totLosslist.get(i).getSPECIES_NM().equals(kind)) {
                    lossDTOS.add(totLosslist.get(i));
                // 종류, 시군구 total / 성별만 검색
                } else if(((kind == null && city == null) || (kind.equals("total") && city.equals("total"))) && sex != null && totLosslist.get(i).getSEX_NM().equals(sex)) {
                    lossDTOS.add(totLosslist.get(i));
                // 성별, 시군구 total / 종류만 검색
                } else if(((sex == null && city == null) || (sex.equals("total") && city.equals("total"))) && kind != null && totLosslist.get(i).getSPECIES_NM().equals(kind)) {
                    lossDTOS.add(totLosslist.get(i));
                // 성별, 종류 total / 시군구만 검색
                } else if(((sex == null && kind == null) || (sex.equals("total") && kind.equals("total"))) && city != null && totLosslist.get(i).getCity().equals(city)) {
                    lossDTOS.add(totLosslist.get(i));
                }
            }
            return lossDTOS;

        } catch (Exception e) {
        }
        return null;
    }
//
//    // 옵션 - 축종
//    public ArrayList<LossDTO> kindlist(String kind) {
//        LossService lossService = new LossService();
//        ArrayList<LossDTO> totLosslist = lossService.totlosslist(); // 전체 리스트
//        ArrayList<LossDTO> lossDTOS = new ArrayList<>();
//        try {
//            if (kind == null || kind.equals("total")) {
//                return totLosslist;
//            }
//            for (int i = 0; i < totLosslist.size(); i++) {
//                if (kind != null && kind.equals("dog")) {
//                    if (totLosslist.get(i).getSPECIES_NM().equals("개")) {
//                        LossDTO lossDTO = LossDTO.builder()
//                                .SIGUN_CD(totLosslist.get(i).getSIGUN_CD())
//                                .SIGUN_NM(totLosslist.get(i).getSIGUN_NM())
//                                .ABDM_IDNTFY_NO(totLosslist.get(i).getABDM_IDNTFY_NO())
//                                .THUMB_IMAGE_COURS(totLosslist.get(i).getTHUMB_IMAGE_COURS())
//                                .RECEPT_DE(totLosslist.get(i).getRECEPT_DE())
//                                .DISCVRY_PLC_INFO(totLosslist.get(i).getDISCVRY_PLC_INFO())
//                                .SPECIES_NM(totLosslist.get(i).getSPECIES_NM())
//                                .COLOR_NM(totLosslist.get(i).getCOLOR_NM())
//                                .AGE_INFO(totLosslist.get(i).getAGE_INFO())
//                                .BDWGH_INFO(totLosslist.get(i).getBDWGH_INFO())
//                                .PBLANC_IDNTFY_NO(totLosslist.get(i).getPBLANC_IDNTFY_NO())
//                                .PBLANC_BEGIN_DE(totLosslist.get(i).getPBLANC_BEGIN_DE())
//                                .PBLANC_END_DE(totLosslist.get(i).getPBLANC_END_DE())
//                                .IMAGE_COURS(totLosslist.get(i).getIMAGE_COURS())
//                                .STATE_NM(totLosslist.get(i).getSTATE_NM())
//                                .SEX_NM(totLosslist.get(i).getSEX_NM())
//                                .NEUT_YN(totLosslist.get(i).getNEUT_YN())
//                                .SFETR_INFO(totLosslist.get(i).getSFETR_INFO())
//                                .SHTER_NM(totLosslist.get(i).getSHTER_NM())
//                                .SHTER_TELNO(totLosslist.get(i).getSHTER_TELNO())
//                                .PROTECT_PLC(totLosslist.get(i).getPROTECT_PLC())
//                                .JURISD_INST_NM(totLosslist.get(i).getJURISD_INST_NM())
//                                .CHRGPSN_NM(totLosslist.get(i).getCHRGPSN_NM())
//                                .CHRGPSN_CONTCT_NO(totLosslist.get(i).getCHRGPSN_CONTCT_NO())
//                                .PARTCLR_MATR(totLosslist.get(i).getPARTCLR_MATR())
//                                .REFINE_LOTNO_ADDR(totLosslist.get(i).getREFINE_LOTNO_ADDR())
//                                .REFINE_ROADNM_ADDR(totLosslist.get(i).getREFINE_ROADNM_ADDR())
//                                .REFINE_ZIP_CD(totLosslist.get(i).getREFINE_ZIP_CD())
//                                .REFINE_WGS84_LOGT(totLosslist.get(i).getREFINE_WGS84_LOGT())
//                                .REFINE_WGS84_LAT(totLosslist.get(i).getREFINE_WGS84_LAT())
//                                .build();
//                        lossDTOS.add(lossDTO);
//                    }
//                } else if (kind != null && kind.equals("cat")) {
//                    if (totLosslist.get(i).getSPECIES_NM().equals("고양이")) {
//                        LossDTO lossDTO = LossDTO.builder()
//                                .SIGUN_CD(totLosslist.get(i).getSIGUN_CD())
//                                .SIGUN_NM(totLosslist.get(i).getSIGUN_NM())
//                                .ABDM_IDNTFY_NO(totLosslist.get(i).getABDM_IDNTFY_NO())
//                                .THUMB_IMAGE_COURS(totLosslist.get(i).getTHUMB_IMAGE_COURS())
//                                .RECEPT_DE(totLosslist.get(i).getRECEPT_DE())
//                                .DISCVRY_PLC_INFO(totLosslist.get(i).getDISCVRY_PLC_INFO())
//                                .SPECIES_NM(totLosslist.get(i).getSPECIES_NM())
//                                .COLOR_NM(totLosslist.get(i).getCOLOR_NM())
//                                .AGE_INFO(totLosslist.get(i).getAGE_INFO())
//                                .BDWGH_INFO(totLosslist.get(i).getBDWGH_INFO())
//                                .PBLANC_IDNTFY_NO(totLosslist.get(i).getPBLANC_IDNTFY_NO())
//                                .PBLANC_BEGIN_DE(totLosslist.get(i).getPBLANC_BEGIN_DE())
//                                .PBLANC_END_DE(totLosslist.get(i).getPBLANC_END_DE())
//                                .IMAGE_COURS(totLosslist.get(i).getIMAGE_COURS())
//                                .STATE_NM(totLosslist.get(i).getSTATE_NM())
//                                .SEX_NM(totLosslist.get(i).getSEX_NM())
//                                .NEUT_YN(totLosslist.get(i).getNEUT_YN())
//                                .SFETR_INFO(totLosslist.get(i).getSFETR_INFO())
//                                .SHTER_NM(totLosslist.get(i).getSHTER_NM())
//                                .SHTER_TELNO(totLosslist.get(i).getSHTER_TELNO())
//                                .PROTECT_PLC(totLosslist.get(i).getPROTECT_PLC())
//                                .JURISD_INST_NM(totLosslist.get(i).getJURISD_INST_NM())
//                                .CHRGPSN_NM(totLosslist.get(i).getCHRGPSN_NM())
//                                .CHRGPSN_CONTCT_NO(totLosslist.get(i).getCHRGPSN_CONTCT_NO())
//                                .PARTCLR_MATR(totLosslist.get(i).getPARTCLR_MATR())
//                                .REFINE_LOTNO_ADDR(totLosslist.get(i).getREFINE_LOTNO_ADDR())
//                                .REFINE_ROADNM_ADDR(totLosslist.get(i).getREFINE_ROADNM_ADDR())
//                                .REFINE_ZIP_CD(totLosslist.get(i).getREFINE_ZIP_CD())
//                                .REFINE_WGS84_LOGT(totLosslist.get(i).getREFINE_WGS84_LOGT())
//                                .REFINE_WGS84_LAT(totLosslist.get(i).getREFINE_WGS84_LAT())
//                                .build();
//                        lossDTOS.add(lossDTO);
//                    }
//                } else if (kind != null && kind.equals("other1")) {
//                    if (totLosslist.get(i).getSPECIES_NM().equals("기타축종")) {
//                        LossDTO lossDTO = LossDTO.builder()
//                                .SIGUN_CD(totLosslist.get(i).getSIGUN_CD())
//                                .SIGUN_NM(totLosslist.get(i).getSIGUN_NM())
//                                .ABDM_IDNTFY_NO(totLosslist.get(i).getABDM_IDNTFY_NO())
//                                .THUMB_IMAGE_COURS(totLosslist.get(i).getTHUMB_IMAGE_COURS())
//                                .RECEPT_DE(totLosslist.get(i).getRECEPT_DE())
//                                .DISCVRY_PLC_INFO(totLosslist.get(i).getDISCVRY_PLC_INFO())
//                                .SPECIES_NM(totLosslist.get(i).getSPECIES_NM())
//                                .COLOR_NM(totLosslist.get(i).getCOLOR_NM())
//                                .AGE_INFO(totLosslist.get(i).getAGE_INFO())
//                                .BDWGH_INFO(totLosslist.get(i).getBDWGH_INFO())
//                                .PBLANC_IDNTFY_NO(totLosslist.get(i).getPBLANC_IDNTFY_NO())
//                                .PBLANC_BEGIN_DE(totLosslist.get(i).getPBLANC_BEGIN_DE())
//                                .PBLANC_END_DE(totLosslist.get(i).getPBLANC_END_DE())
//                                .IMAGE_COURS(totLosslist.get(i).getIMAGE_COURS())
//                                .STATE_NM(totLosslist.get(i).getSTATE_NM())
//                                .SEX_NM(totLosslist.get(i).getSEX_NM())
//                                .NEUT_YN(totLosslist.get(i).getNEUT_YN())
//                                .SFETR_INFO(totLosslist.get(i).getSFETR_INFO())
//                                .SHTER_NM(totLosslist.get(i).getSHTER_NM())
//                                .SHTER_TELNO(totLosslist.get(i).getSHTER_TELNO())
//                                .PROTECT_PLC(totLosslist.get(i).getPROTECT_PLC())
//                                .JURISD_INST_NM(totLosslist.get(i).getJURISD_INST_NM())
//                                .CHRGPSN_NM(totLosslist.get(i).getCHRGPSN_NM())
//                                .CHRGPSN_CONTCT_NO(totLosslist.get(i).getCHRGPSN_CONTCT_NO())
//                                .PARTCLR_MATR(totLosslist.get(i).getPARTCLR_MATR())
//                                .REFINE_LOTNO_ADDR(totLosslist.get(i).getREFINE_LOTNO_ADDR())
//                                .REFINE_ROADNM_ADDR(totLosslist.get(i).getREFINE_ROADNM_ADDR())
//                                .REFINE_ZIP_CD(totLosslist.get(i).getREFINE_ZIP_CD())
//                                .REFINE_WGS84_LOGT(totLosslist.get(i).getREFINE_WGS84_LOGT())
//                                .REFINE_WGS84_LAT(totLosslist.get(i).getREFINE_WGS84_LAT())
//                                .build();
//                        lossDTOS.add(lossDTO);
//                    }
//                }
//            }
//            return lossDTOS;
//
//        } catch (Exception e) {
//        }
//        return null;
//    }
//
//    // 옵션 - 시군구
//    public ArrayList<LossDTO> citylist(String keyword) {
//        LossService lossService = new LossService();
//        ArrayList<LossDTO> totLosslist = lossService.totlosslist(); // 전체 리스트
//        ArrayList<LossDTO> lossDTOS = new ArrayList<>();
//        try {
//            if (keyword == null || keyword.equals("total")) {
//                return totLosslist;
//            }
//            for (int i = 0; i < totLosslist.size(); i++) {
//                if (keyword != null && keyword.equals("a")) {
//                    if (totLosslist.get(i).getCity().equals("가평군")) {
//                        LossDTO lossDTO = LossDTO.builder()
//                                .SIGUN_CD(totLosslist.get(i).getSIGUN_CD())
//                                .SIGUN_NM(totLosslist.get(i).getSIGUN_NM())
//                                .ABDM_IDNTFY_NO(totLosslist.get(i).getABDM_IDNTFY_NO())
//                                .THUMB_IMAGE_COURS(totLosslist.get(i).getTHUMB_IMAGE_COURS())
//                                .RECEPT_DE(totLosslist.get(i).getRECEPT_DE())
//                                .DISCVRY_PLC_INFO(totLosslist.get(i).getDISCVRY_PLC_INFO())
//                                .SPECIES_NM(totLosslist.get(i).getSPECIES_NM())
//                                .COLOR_NM(totLosslist.get(i).getCOLOR_NM())
//                                .AGE_INFO(totLosslist.get(i).getAGE_INFO())
//                                .BDWGH_INFO(totLosslist.get(i).getBDWGH_INFO())
//                                .PBLANC_IDNTFY_NO(totLosslist.get(i).getPBLANC_IDNTFY_NO())
//                                .PBLANC_BEGIN_DE(totLosslist.get(i).getPBLANC_BEGIN_DE())
//                                .PBLANC_END_DE(totLosslist.get(i).getPBLANC_END_DE())
//                                .IMAGE_COURS(totLosslist.get(i).getIMAGE_COURS())
//                                .STATE_NM(totLosslist.get(i).getSTATE_NM())
//                                .SEX_NM(totLosslist.get(i).getSEX_NM())
//                                .NEUT_YN(totLosslist.get(i).getNEUT_YN())
//                                .SFETR_INFO(totLosslist.get(i).getSFETR_INFO())
//                                .SHTER_NM(totLosslist.get(i).getSHTER_NM())
//                                .SHTER_TELNO(totLosslist.get(i).getSHTER_TELNO())
//                                .PROTECT_PLC(totLosslist.get(i).getPROTECT_PLC())
//                                .JURISD_INST_NM(totLosslist.get(i).getJURISD_INST_NM())
//                                .CHRGPSN_NM(totLosslist.get(i).getCHRGPSN_NM())
//                                .CHRGPSN_CONTCT_NO(totLosslist.get(i).getCHRGPSN_CONTCT_NO())
//                                .PARTCLR_MATR(totLosslist.get(i).getPARTCLR_MATR())
//                                .REFINE_LOTNO_ADDR(totLosslist.get(i).getREFINE_LOTNO_ADDR())
//                                .REFINE_ROADNM_ADDR(totLosslist.get(i).getREFINE_ROADNM_ADDR())
//                                .city(totLosslist.get(i).getCity())
//                                .REFINE_ZIP_CD(totLosslist.get(i).getREFINE_ZIP_CD())
//                                .REFINE_WGS84_LOGT(totLosslist.get(i).getREFINE_WGS84_LOGT())
//                                .REFINE_WGS84_LAT(totLosslist.get(i).getREFINE_WGS84_LAT())
//                                .build();
//                        lossDTOS.add(lossDTO);
//                    }
//                } else if (keyword != null && keyword.equals("b")) {
//                    if (totLosslist.get(i).getCity().equals("고양시")) {
//                        LossDTO lossDTO = LossDTO.builder()
//                                .SIGUN_CD(totLosslist.get(i).getSIGUN_CD())
//                                .SIGUN_NM(totLosslist.get(i).getSIGUN_NM())
//                                .ABDM_IDNTFY_NO(totLosslist.get(i).getABDM_IDNTFY_NO())
//                                .THUMB_IMAGE_COURS(totLosslist.get(i).getTHUMB_IMAGE_COURS())
//                                .RECEPT_DE(totLosslist.get(i).getRECEPT_DE())
//                                .DISCVRY_PLC_INFO(totLosslist.get(i).getDISCVRY_PLC_INFO())
//                                .SPECIES_NM(totLosslist.get(i).getSPECIES_NM())
//                                .COLOR_NM(totLosslist.get(i).getCOLOR_NM())
//                                .AGE_INFO(totLosslist.get(i).getAGE_INFO())
//                                .BDWGH_INFO(totLosslist.get(i).getBDWGH_INFO())
//                                .PBLANC_IDNTFY_NO(totLosslist.get(i).getPBLANC_IDNTFY_NO())
//                                .PBLANC_BEGIN_DE(totLosslist.get(i).getPBLANC_BEGIN_DE())
//                                .PBLANC_END_DE(totLosslist.get(i).getPBLANC_END_DE())
//                                .IMAGE_COURS(totLosslist.get(i).getIMAGE_COURS())
//                                .STATE_NM(totLosslist.get(i).getSTATE_NM())
//                                .SEX_NM(totLosslist.get(i).getSEX_NM())
//                                .NEUT_YN(totLosslist.get(i).getNEUT_YN())
//                                .SFETR_INFO(totLosslist.get(i).getSFETR_INFO())
//                                .SHTER_NM(totLosslist.get(i).getSHTER_NM())
//                                .SHTER_TELNO(totLosslist.get(i).getSHTER_TELNO())
//                                .PROTECT_PLC(totLosslist.get(i).getPROTECT_PLC())
//                                .JURISD_INST_NM(totLosslist.get(i).getJURISD_INST_NM())
//                                .CHRGPSN_NM(totLosslist.get(i).getCHRGPSN_NM())
//                                .CHRGPSN_CONTCT_NO(totLosslist.get(i).getCHRGPSN_CONTCT_NO())
//                                .PARTCLR_MATR(totLosslist.get(i).getPARTCLR_MATR())
//                                .REFINE_LOTNO_ADDR(totLosslist.get(i).getREFINE_LOTNO_ADDR())
//                                .REFINE_ROADNM_ADDR(totLosslist.get(i).getREFINE_ROADNM_ADDR())
//                                .city(totLosslist.get(i).getCity())
//                                .REFINE_ZIP_CD(totLosslist.get(i).getREFINE_ZIP_CD())
//                                .REFINE_WGS84_LOGT(totLosslist.get(i).getREFINE_WGS84_LOGT())
//                                .REFINE_WGS84_LAT(totLosslist.get(i).getREFINE_WGS84_LAT())
//                                .build();
//                        lossDTOS.add(lossDTO);
//                    }
//                } else if (keyword != null && keyword.equals("aa")) {
//                    if (totLosslist.get(i).getCity().equals("파주시")) {
//                        LossDTO lossDTO = LossDTO.builder()
//                                .SIGUN_CD(totLosslist.get(i).getSIGUN_CD())
//                                .SIGUN_NM(totLosslist.get(i).getSIGUN_NM())
//                                .ABDM_IDNTFY_NO(totLosslist.get(i).getABDM_IDNTFY_NO())
//                                .THUMB_IMAGE_COURS(totLosslist.get(i).getTHUMB_IMAGE_COURS())
//                                .RECEPT_DE(totLosslist.get(i).getRECEPT_DE())
//                                .DISCVRY_PLC_INFO(totLosslist.get(i).getDISCVRY_PLC_INFO())
//                                .SPECIES_NM(totLosslist.get(i).getSPECIES_NM())
//                                .COLOR_NM(totLosslist.get(i).getCOLOR_NM())
//                                .AGE_INFO(totLosslist.get(i).getAGE_INFO())
//                                .BDWGH_INFO(totLosslist.get(i).getBDWGH_INFO())
//                                .PBLANC_IDNTFY_NO(totLosslist.get(i).getPBLANC_IDNTFY_NO())
//                                .PBLANC_BEGIN_DE(totLosslist.get(i).getPBLANC_BEGIN_DE())
//                                .PBLANC_END_DE(totLosslist.get(i).getPBLANC_END_DE())
//                                .IMAGE_COURS(totLosslist.get(i).getIMAGE_COURS())
//                                .STATE_NM(totLosslist.get(i).getSTATE_NM())
//                                .SEX_NM(totLosslist.get(i).getSEX_NM())
//                                .NEUT_YN(totLosslist.get(i).getNEUT_YN())
//                                .SFETR_INFO(totLosslist.get(i).getSFETR_INFO())
//                                .SHTER_NM(totLosslist.get(i).getSHTER_NM())
//                                .SHTER_TELNO(totLosslist.get(i).getSHTER_TELNO())
//                                .PROTECT_PLC(totLosslist.get(i).getPROTECT_PLC())
//                                .JURISD_INST_NM(totLosslist.get(i).getJURISD_INST_NM())
//                                .CHRGPSN_NM(totLosslist.get(i).getCHRGPSN_NM())
//                                .CHRGPSN_CONTCT_NO(totLosslist.get(i).getCHRGPSN_CONTCT_NO())
//                                .PARTCLR_MATR(totLosslist.get(i).getPARTCLR_MATR())
//                                .REFINE_LOTNO_ADDR(totLosslist.get(i).getREFINE_LOTNO_ADDR())
//                                .REFINE_ROADNM_ADDR(totLosslist.get(i).getREFINE_ROADNM_ADDR())
//                                .city(totLosslist.get(i).getCity())
//                                .REFINE_ZIP_CD(totLosslist.get(i).getREFINE_ZIP_CD())
//                                .REFINE_WGS84_LOGT(totLosslist.get(i).getREFINE_WGS84_LOGT())
//                                .REFINE_WGS84_LAT(totLosslist.get(i).getREFINE_WGS84_LAT())
//                                .build();
//                        lossDTOS.add(lossDTO);
//                    }
//                }
//            }
//            return lossDTOS;
//
//        } catch (Exception e) {
//        }
//        return null;
//    }

}