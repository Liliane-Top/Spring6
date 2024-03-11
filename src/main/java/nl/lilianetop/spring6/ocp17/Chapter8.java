package nl.lilianetop.spring6.ocp17;

import java.util.function.*;

public class Chapter8 {
    public static void main(String[] args) {
        Consumer<String> x = a -> System.out.println("1: " + a);
        Consumer<String> y = a -> System.out.println("2: " + a);
        Consumer<String> combined = x.andThen(y);
//        BiConsumer<String, String> combined = x.andThen(y);//Compile Error
        combined.accept("liliane");


    }

    public static void scary(String animal) {
//        var dino = s -> "dino".equals(animal);//can't infer type
        Predicate<String> dino = s -> "dino".equals(animal);
        Function<String, Boolean> dragon = s-> "dragon".equals(animal);
    }
}
