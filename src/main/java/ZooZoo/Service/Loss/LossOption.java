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

}