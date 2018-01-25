package functional.interfaces;

import java.util.function.ObjDoubleConsumer;

class ObjDoubleConsumerTest {

    public static void main(String[] args) {
        ObjDoubleConsumer<String> i  = (s, d) -> System.out.println(s+d);
        i.accept("Valor ",0.1234);
    }

}
