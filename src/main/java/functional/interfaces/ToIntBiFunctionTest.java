package functional.interfaces;

import java.util.function.ToIntBiFunction;

public class ToIntBiFunctionTest {

    public static void main(String[] args) {
        ToIntBiFunction<String,String> i  = (x, y)-> Integer.parseInt(x) + Integer.parseInt(y);

        System.out.println(i.applyAsInt("2","3"));
    }

}
