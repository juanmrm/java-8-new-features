package functional.interfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {

    public static void main(String[] args) {
        UnaryOperator<String> i  = String::toUpperCase;

        System.out.println(i.apply("valor"));
    }

}
