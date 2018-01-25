package functional.interfaces;

import java.util.function.ObjIntConsumer;

class ObjIntConsumerTest {

    public static void main(String[] args) {
        ObjIntConsumer<String> i  = (s, d) -> System.out.println(s+d);

        i.accept("Valor ",234);
    }

}
