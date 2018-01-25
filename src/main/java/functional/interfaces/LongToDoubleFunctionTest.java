package functional.interfaces;

import java.util.function.LongToDoubleFunction;

class LongToDoubleFunctionTest {

    public static void main(String[] args) {
        LongToDoubleFunction i = (l) -> Math.sin(l);

        System.out.println(i.applyAsDouble(Long.MAX_VALUE));
    }

}
