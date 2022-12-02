import java.util.Arrays;

public class QuickSort {

    public int partition(int[] array, int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for element greater than the pivot
        int i = (low - 1);

        // traverse through all elements and compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found, swap it with the element greater than the pivot pointed by i
                i++;

                // swapping element at i with element at j
                if (i != j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

        }

        // swap the pivot element with the first element greater than the pivot specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the index of the pivot
        return (i + 1);
    }

    public void quickSort(int[] array, int low, int high) {

        if (low >= high) return;

        // find the pivot element such that
        // elements smaller than pivot are on the left
        // elements greater than pivot are on the right
        int pivot = partition(array, low, high);

        // recursive call on the left of pivot
        quickSort(array, low, pivot - 1);

        // recursive call on the right of pivot
        quickSort(array, pivot + 1, high);
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,2,8,1,-5,2,1,6,7,-4,-3};
        QuickSort obj = new QuickSort();
        obj.quickSort(test, 0, test.length-1);
        System.out.println(Arrays.toString(test));
    }
}
