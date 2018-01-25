package functional.interfaces;

import java.util.function.LongToDoubleFunction;

class LongToDoubleFunctionTest {

    public static void main(String[] args) {
        LongToDoubleFunction i = Math::sin;

        System.out.println(i.applyAsDouble(Long.MAX_VALUE));
    }

}
