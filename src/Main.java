import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1(){
        System.out.println("\nЗадание 1:");
        System.out.println("через анонимный класс");
        Predicate<Integer> predicate = new Predicate<Integer>() {   //Anonymous new Predicate<Integer>() can be replaced with lambda
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));
        System.out.println("через лямбду");
        Predicate<Integer> predicate1 = integer -> integer > 0;
        System.out.println(predicate1.test(-1));
        System.out.println(predicate1.test(1));
    }

    public static void task2() {
        System.out.println("\nЗадание 2:");
        System.out.println("через анонимный класс");
        Consumer<String> consumer = new Consumer<String>() {   //Anonymous new Consumer<String>() can be replaced with lambda
            @Override
            public void accept(String s) {
                    System.out.println("Привет " + s);
                }
            };
        consumer.accept("Людвиг Аристархович");
        System.out.println("через лямбду");
            Consumer<String> consumer1 = s -> System.out.println("Приветствую " + s);
        consumer1.accept("Людвиг Аристархович");
        }

    public static void task3() {
        System.out.println("\nЗадание 3:");
        System.out.println("через анонимный класс");
        Function<Double, Long> function = new Function<Double, Long>() {   //Anonymous new Function<Double, Long>() can be replaced with lambda
            @Override
            public Long apply(Double d) {
                return (long) d.intValue();
            }
        };
        System.out.println(function.apply(36.6));
        System.out.println("через лямбду");
        Function<Double, Long> function1 = Math::round;
        System.out.println(function1.apply(37.7));
    }

    public static void task4() {
        System.out.println("\nЗадание 4:");
        System.out.println("через анонимный класс");
        Supplier<Integer> supplier = new Supplier<Integer>() {   //Anonymous new Supplier<Integer>() can be replaced with lambda
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);
                }
        };
        System.out.println(supplier.get());
        System.out.println("через лямбду");
        Supplier<Integer> supplier1 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };
        System.out.println(supplier1.get());
    }

    public static void task5() {
        System.out.println("\nЗадание 5 (опциональное)");
        String string = "Всем привет!";
        System.out.println(string);

        Predicate<String> condition = name -> (name.contains("Здравствуйте!"));
        Function<String, String> function1 = name -> name.replace("Всем привет!", "Приветствую!");
        Function<String, String> function2 = name -> name.replace("Всем привет!", "Добро пожаловать!");

        System.out.println(checkThenSubstitute(condition, function1).apply(string));
        System.out.println(ternaryOperator(condition, function1, function2).apply(string));
    }

   public static Function<String, String> checkThenSubstitute(Predicate<String> condition, Function<String, String> function) {
   return string -> condition.test(string) ? function.apply(string) : string;
   }

   public static <T, U> Function<T, U> ternaryOperator(
   Predicate<? super T> condition,
   Function<? super T, ? extends U> ifTrue,
   Function<? super T, ? extends U> ifFalse) {
   return string -> condition.test(string) ? ifTrue.apply(string) : ifFalse.apply(string);
   }

}