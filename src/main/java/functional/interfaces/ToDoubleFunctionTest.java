package functional.interfaces;

import java.util.function.ToDoubleFunction;

public class ToDoubleFunctionTest {

    public static void main(String[] args) {
        ToDoubleFunction<Integer> i  = Math::sin;

        System.out.println(i.applyAsDouble(Integer.MAX_VALUE));
    }

}
