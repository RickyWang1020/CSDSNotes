import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create an array by assigning the length
        String[] new_arr = new String[5];
        new_arr[0] = "hi";
        String x = new_arr[1];
        System.out.println(x); // null

        // create an array by listing all elements
        double[] new_arr_int = {1,2,5.5,3};
        System.out.println(new_arr_int[2]); // will automatically become double type

        // for loop to iterate in an array
        for (int i=0; i<new_arr_int.length; i++) {
            System.out.println(new_arr_int[i]);
        }
        // a better expression
        int count = 0;
        for (double val: new_arr_int) {
            System.out.println(val + " " + count);
            count ++;
        }

        // do while loop
        Scanner sc = new Scanner(System.in);
        int var;
        do {
            var = sc.nextInt();
            System.out.println("You wrote " + var);
        } while (var != 10);
    }
}
