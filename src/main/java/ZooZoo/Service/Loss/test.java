package ZooZoo.Service.Loss;

import ZooZoo.Domain.DTO.Board.LossDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        LossService lossService = new LossService();
        ArrayList<LossDTO> totLosslist = lossService.totlosslist();

        for (int i = 0; i < totLosslist.size(); i++) {
            System.out.println(totLosslist.get(i).getNewPBLANC_END_DE());
        }

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        try {
            String str = "20220210";
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date date = format.parse(str);
            System.out.println("str : " +date);

            Date date1 = new Date();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String str1 = format1.format(date);
            System.out.println("date : " +str1);

            Date date2 = new Date();
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String now = format.format(date2);
            System.out.println(now);

            int compare = str.compareTo(now);
            System.out.println("비교 : " + compare);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
