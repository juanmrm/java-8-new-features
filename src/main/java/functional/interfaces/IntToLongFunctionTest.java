package functional.interfaces;

import java.util.function.IntToLongFunction;

class IntToLongFunctionTest {

    public static void main(String[] args) {
        IntToLongFunction i = (x) -> Long.MAX_VALUE - x;
        System.out.println(i.applyAsLong(2));
    }

}
