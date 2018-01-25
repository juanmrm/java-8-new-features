package functional.interfaces;

import java.util.function.LongToIntFunction;

class LongToIntFunctionTest {

    public static void main(String[] args) {
        LongToIntFunction i = (l) -> (int)l;

        System.out.println(i.applyAsInt(Long.MAX_VALUE));
    }

}
