import java.util.Arrays;

public class HeapSort {

    public void heapSort(int[] arr) {

        int len = arr.length;
        // bottom-up heapify
        // build a max heap
        for (int i = len/2-1; i >= 0; i--) {
            heapify(arr, len, i);
        }
        // every iteration, remove the root node and swap it with the last element in heap
        for (int i = len-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // heapify on the newly-swapped root node to maintain heap structure
            heapify(arr, i, 0);
        }
    }

    public void heapify(int[] arr, int length, int root) {

        // have a variable to track the current largest element's index, left element's index and right element's index
        int max = root;
        int left = 2 * root + 1, right = 2 * root + 2;

        // compare root element with left element and right element, get the largest element
        if (left < length && arr[left] > arr[max]) {
            max = left;
        }
        if (right < length && arr[right] > arr[max]) {
            max = right;
        }

        // if root is smaller than either left or right, swap root with the larger child
        if (max != root) {
             int temp = arr[root];
             arr[root] = arr[max];
             arr[max] = temp;
             // then recursively heapify the subtree that we have swapped the root into
             heapify(arr, length, max);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,2,8,1,-5,2,1,6,7,-4,-3};
        HeapSort obj = new HeapSort();
        obj.heapSort(test);
        System.out.println(Arrays.toString(test));
    }
}
