package ZooZoo.Service.Loss;

import ZooZoo.Domain.DTO.Board.LossDTO;
import ZooZoo.Domain.DTO.Pagination;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String MyString = "Hello World";
        System.out.println("The string before removing character: " + MyString);
        MyString = MyString.replace(" ", "");
        System.out.println("The string after removing character: " + MyString);

        String a1 = "[개] 믹스견";
        String a2 = "[고양이] 한국 고양이";
        String a3 = "[고양이]";
        a3 = a3.replace("[", "");
        try{
            String result = a3.split("]")[1];
            System.out.println(result);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("공란");

        }


    }

}
