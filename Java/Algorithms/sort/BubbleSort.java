import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,2,3,1,-1,5,2,1,6,6,2};
        bubbleSort(test);
        System.out.println(Arrays.toString(test));
    }
}
