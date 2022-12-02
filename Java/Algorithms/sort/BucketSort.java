import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public void bucketSort(double[] array, int k) {

        ArrayList<Double>[] bucket = new ArrayList[k];

        // Create empty buckets
        for (int i = 0; i < k; i++)
            bucket[i] = new ArrayList<>();

        // Add elements into the buckets
        for (int i = 0; i < k; i++) {
            int bucketIndex = (int) array[i] * k;
            bucket[bucketIndex].add(array[i]);
        }

        // Sort the elements of each bucket
        for (int i = 0; i < k; i++) {
            Collections.sort((bucket[i]));
        }

        // Get the sorted array
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                array[index++] = bucket[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        double[] test = new double[]{.42, .32, .33, .52, .37, .47, .51};
        BucketSort obj = new BucketSort();
        obj.bucketSort(test, 7);
        System.out.println(Arrays.toString(test));
    }
}
