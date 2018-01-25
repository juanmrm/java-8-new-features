package functional.interfaces;

import java.util.function.ObjLongConsumer;

class ObjLongConsumerTest {

    public static void main(String[] args) {
        ObjLongConsumer<String> i  = (s, d) -> System.out.println(s+d);

        i.accept("Value ",Long.MAX_VALUE);
    }

}
