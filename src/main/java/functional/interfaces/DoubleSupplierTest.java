package functional.interfaces;

import java.util.function.DoubleSupplier;

class DoubleSupplierTest {

    public static void main(String[] args) {

        DoubleSupplier pi = () -> Math.round(Math.random() * 10);

        for (int i = 0; i < 10; i++) {
            System.out.println(pi.getAsDouble());
        }
    }

}
