package functional.interfaces;

import java.util.function.DoubleToIntFunction;

class DoubleToIntFunctionTest {

    public static void main(String[] args) {

        DoubleToIntFunction df = (x) -> (int) x + 2;

        System.out.println(df.applyAsInt(3.14));
    }
}
