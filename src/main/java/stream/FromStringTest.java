package stream;

import java.util.regex.Pattern;

public class FromStringTest {

    public static void main(String[] args) {
        String str1 = "5 123,123,qwe,1,123, 25";
        str1.chars()
                .filter(n ->  !Character.isDigit((char)n) &&   !Character.isWhitespace((char)n))
                .forEach(n ->  System.out.print((char)n));

        System.out.println("splitAsStream");
        String str2 = "XML,CSS,HTML";
        Pattern.compile(",")
                .splitAsStream(str2)
                .forEach(System.out::println);


    }

}
