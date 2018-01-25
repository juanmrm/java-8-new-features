package functional.interfaces;

import java.util.function.ToLongBiFunction;

public class ToLongBiFunctionTest {

    public static void main(String[] args) {
        ToLongBiFunction<String,String> i  = (x, y) -> Long.parseLong(x) + Long.parseLong(y);

        System.out.println(i.applyAsLong("2","3"));
    }

}
