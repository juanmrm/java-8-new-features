package functional.interfaces;

import java.util.function.LongSupplier;

class LongSupplierTest {

    public static void main(String[] args) {
        LongSupplier i = () -> Long.MAX_VALUE;

        System.out.println(i.getAsLong());
    }

}
