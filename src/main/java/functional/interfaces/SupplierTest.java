package functional.interfaces;

import dto.Student;

import java.util.Objects;
import java.util.function.Supplier;

class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> i  = () -> "Valor";
        System.out.println(i.get());

        // how to pass Supplier as parameter.
        SunPower power = new SunPower();

        SunPower p1 = produce(() -> power);
        SunPower p2 = produce(() -> power);

        System.out.println("Check the same object? " + Objects.equals(p1, p2));

        // how to use Constructor as method reference for Supplier
        System.out.println(maker(Employee::new));

        // how to assign user defined function to Supplier with method reference.
        Supplier<Student> studentGenerator = SupplierTest::employeeMaker;

        for (int j = 0; j < 10; j++) {
            System.out.println("#" + j + ": " + studentGenerator.get());
        }
    }

    static SunPower produce(Supplier<SunPower> supp) {
        return supp.get();
    }

    static Employee maker(Supplier<Employee> fx) {
        return fx.get();
    }

    static Student employeeMaker() {
        return new Student((int)Math.ceil(Math.random() * 10), 30_000, "Pepe");
    }

}

class SunPower {

    public SunPower() {
        System.out.println("Sun Power initialized..");
    }
}

class Employee {
    @Override
    public String toString() {
        return "A EMPLOYEE";
    }
}
