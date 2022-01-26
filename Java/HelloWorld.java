// scanner for getting inputs
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");

        // int, double, char, boolean are primitive variables
        int hello_hello = 5;
        double hello_float = 5;
        String str = "abcde";
        System.out.println(hello_hello);
        System.out.println(hello_float);
        System.out.println(Math.pow(5, 2));

        // get input from system.in
        Scanner sc = new Scanner(System.in);
        // next is a string
        String scanned = sc.next();
        // nextInt is an int; also we have nextBoolean, nextDouble and so on
        int scanned_int = sc.nextInt();
        System.out.println(scanned);
        System.out.println(scanned_int);

        // can convert string to int if it is an integer string
        int int_convert = Integer.parseInt("1234");
        System.out.println(int_convert);

        // compare two strings
        boolean is_equal = scanned.equals("hi");
        System.out.println(is_equal);
    }
}