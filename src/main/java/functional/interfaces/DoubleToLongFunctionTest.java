package functional.interfaces;

import java.util.function.DoubleToLongFunction;

class DoubleToLongFunctionTest {

    public static void main(String[] args) {
        DoubleToLongFunction dl = (x) -> Long.MAX_VALUE - (long) x;
        System.out.println(dl.applyAsLong(3.14));
    }

}
