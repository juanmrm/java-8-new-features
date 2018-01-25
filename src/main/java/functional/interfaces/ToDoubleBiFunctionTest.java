package functional.interfaces;

import java.util.function.ToDoubleBiFunction;

public class ToDoubleBiFunctionTest {

    public static void main(String[] args) {
        ToDoubleBiFunction<Integer,Long> i  = (x, y)-> Math.sin(x ) + Math.sin(y);

        System.out.println(i.applyAsDouble(Integer.MAX_VALUE, Long.MAX_VALUE));
    }

}
