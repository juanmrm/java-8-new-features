package functional.interfaces;

import java.util.function.ToLongFunction;

public class ToLongFunctionTest {

    public static void main(String[] args) {
        ToLongFunction<String> i  = Long::parseLong;

        System.out.println(i.applyAsLong("2"));
    }

}
