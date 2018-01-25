package functional.interfaces;

import java.util.function.IntSupplier;

class IntSupplierTest {

    public static void main(String[] args) {
        IntSupplier i = ()-> Integer.MAX_VALUE;

        System.out.println(i.getAsInt());
    }

}
