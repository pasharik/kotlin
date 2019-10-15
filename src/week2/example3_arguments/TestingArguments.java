package week2.example3_arguments;

public class TestingArguments {
    public static void main(String[] args) {
        //From Java can't use default arguments - need to specify each argument explicitly
        ArgumentsKt.repeatSeparator("*", 10);

        System.out.println(ArgumentsKt.multiply(10));
        System.out.println(ArgumentsKt.multiply(10, 2));
    }
}
