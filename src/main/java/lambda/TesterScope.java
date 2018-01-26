package lambda;

import java.util.function.Consumer;

class TesterScope {

    private final static String salutation = "Hello! ";

    public static void main(String args[]) {
        GreetingService greetService1 = message -> System.out.println(salutation + message);
        greetService1.sayMessage("Mahesh");

        //int x= 0; //If we uncomment this line, there is a compilation error because of the scope.
        Consumer<String> func1 = x -> System.out.println(x);
        func1.accept("");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
