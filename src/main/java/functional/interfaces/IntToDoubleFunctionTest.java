package functional.interfaces;

import java.util.function.IntToDoubleFunction;

class IntToDoubleFunctionTest {

    public static void main(String[] args) {
        IntToDoubleFunction i = (x) -> Math.sin((x * Math.PI) / 180);
        System.out.println(i.applyAsDouble(90));
    }

}
