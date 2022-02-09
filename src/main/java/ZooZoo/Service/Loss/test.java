package ZooZoo.Service.Loss;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String MyString = "Hello World";
        System.out.println("The string before removing character: " + MyString);
        MyString = MyString.replace(" ", "");
        System.out.println("The string after removing character: " + MyString);

        String a1 = "[개] 믹스견";
        String a2 = "[고양이] 한국 고양이";
        a1 = a1.replace("[", "");
        String result = a1.split("] ")[1];
        System.out.println(result);


    }

}
