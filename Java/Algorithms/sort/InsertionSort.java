import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > cur) {
                arr[j+1] = arr[j];
                j --;
            }
            arr[j+1] = cur;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,2,8,1,-5,2,1,6,7,-4,-3};
        InsertionSort obj = new InsertionSort();
        obj.insertionSort(test);
        System.out.println(Arrays.toString(test));
    }
}
