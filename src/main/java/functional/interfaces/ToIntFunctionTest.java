package functional.interfaces;

import java.util.function.ToIntFunction;

public class ToIntFunctionTest {

    public static void main(String[] args) {
        ToIntFunction<String> i  = Integer::parseInt;

        System.out.println(i.applyAsInt("2"));
    }
}
