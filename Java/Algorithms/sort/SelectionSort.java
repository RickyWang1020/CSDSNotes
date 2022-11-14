import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int curMinIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[curMinIdx]) {
                    curMinIdx = j;
                }
            }
            if (curMinIdx != i) {
                int temp = arr[curMinIdx];
                arr[curMinIdx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,2,3,1,-5,2,1,6,8,-4};
        selectionSort(test);
        System.out.println(Arrays.toString(test));
    }
}
