package ZooZoo.Controller.Api;

import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) throws IOException {
        String urlStr = "http://api.odcloud.kr/api/nts-businessman/v1/validate?serviceKey=1LB54yX2%2BHgedpJ5WPtUlCgis3Wj3ulEoeJorsRTkrxmbfRPO21aodfkeLX%2BJ5UUM8nOZdSDoY18dKpdd6shAA%3D%3D";
        Map<String, Object> map = new HashMap<>();
        map.put("b_no", "");
        map.put("start_dt", "");
        map.put("p_nm", "");
        map.put("p_nm2", "");
        map.put("b_nm", "");
        map.put("corp_no", "");
        map.put("b_sector", "");
        map.put("b_type", "");

        List<Map<String, Object>> jsonObjects = new ArrayList<>();
        jsonObjects.add(map);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("businesses", jsonObjects);

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(jsonObject.toString(), mediaType);

        System.out.println(jsonObject);

        Request request = new Request.Builder()
                .url(urlStr)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try{
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(res);
            JSONObject jsonObj = (JSONObject) obj;
            System.out.println(jsonObj);

        } catch (Exception e) {
            System.out.println("오류");
        }


    }
}
