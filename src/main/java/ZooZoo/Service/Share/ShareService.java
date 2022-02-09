package ZooZoo.Service.Share;

import ZooZoo.Domain.DTO.Board.ShareDTO;
import ZooZoo.Domain.DTO.Pagination;
import ZooZoo.Domain.Entity.Board.BoardRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

@Service
public class ShareService {
    @Autowired
    BoardRepository boardRepository;

    public ArrayList<String> Share() {
        try {
            ArrayList<String> total = new ArrayList<>();
            for(int qq = 1; qq <= 8; qq++) {
                URL url = new URL("https://openapi.gg.go.kr/AnimalSale?Key=d33e0915e37c453abb4d9a94d8f265ed&Type=json&pIndex=" + qq + "&pSize=1000");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                String result = bufferedReader.readLine();
                JSONParser jsonParser = new JSONParser(); // JSON을 쓰기 위해 사용
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result); // 오브젝트에 가져온 데이터 넣기
                JSONArray jsonArray = (JSONArray) jsonObject.get("AnimalSale"); // 오브젝트에 있는 데이터 배열에 넣기
                JSONObject object = (JSONObject) jsonArray.get(1); // head, row가 있는데 이 중 1번째(row)만 오브젝트에 넣기
                JSONArray arr = (JSONArray) object.get("row"); // row(key)의 값(value) 가져와 배열에 넣기
//                System.out.println(arr.size());
                ArrayList<String> address = new ArrayList<>();
                ArrayList<String> name = new ArrayList<>();
                ArrayList<String> info = new ArrayList<>();
//                System.out.println(arr);
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) != null) {
                        JSONObject obj = (JSONObject) arr.get(i); // 오브젝트에 i번째 데이터 넣기
                        JSONObject obj1 = (JSONObject) arr.get(i);
                        // 오브젝트에 있는 값중 REFINE_ROADNM_ADDR(key)의 값(value)을 가져와 배열에 넣기
                        address.add((String) obj.get("REFINE_ROADNM_ADDR"));
                        name.add((String) obj1.get("BIZPLC_NM"));
                        if(qq == 1) {
                            info.add((i + 1) + ":" + address.get(i) + ":" + name.get(i));
//                            System.out.println(info.size());
                        } else {
                            info.add((total.size() + 1) + ":" + address.get(i) + ":" + name.get(i));
                        }
                    }
                    total.add(info.get(i));
                }
            }
            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}