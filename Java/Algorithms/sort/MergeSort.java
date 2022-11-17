import java.util.Arrays;

public class MergeSort {

    public void mergeSortRecur(int[] arr) {

        int len = arr.length;
        if (len == 0 || len == 1) return;

        // divide into half: left and right arrays
        int mid = len / 2;
        int[] left = new int[mid], right = new int[len-mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < len-mid; i++) {
            right[i] = arr[i+mid];
        }
        mergeSortRecur(left);
        mergeSortRecur(right);

        // merge the two sorted arrays
        int leftPtr = 0, rightPtr = 0, ptr = 0;
        while (leftPtr < left.length && rightPtr < right.length) {
            if (left[leftPtr] < right[rightPtr]) {
                arr[ptr] = left[leftPtr];
                leftPtr ++;
            }
            else {
                arr[ptr] = right[rightPtr];
                rightPtr ++;
            }
            ptr ++;
        }
        while (leftPtr < left.length) {
            arr[ptr] = left[leftPtr];
            leftPtr ++;
            ptr ++;
        }
        while (rightPtr < right.length) {
            arr[ptr] = right[rightPtr];
            rightPtr ++;
            ptr ++;
        }
    }

    // bottom-up merging the subarrays
    public void mergeSortIter(int[] arr) {

        // current size of subarray to merge: range from 1 to n/2
        for (int curSize = 1; curSize <= arr.length-1; curSize=curSize*2) {
            // starting point of different arrays of the given current size
            for (int leftStart = 0; leftStart <= arr.length-1; leftStart += 2*curSize) {
                int mid = Math.min(leftStart + curSize - 1, arr.length - 1);
                int rightEnd = Math.min(leftStart + 2 * curSize - 1, arr.length - 1);

                // perform merge
                int leftLen = mid - leftStart + 1, rightLen = rightEnd - mid;
                int[] left = new int[leftLen], right= new int[rightLen];
                for (int i = 0; i < leftLen; i++) {
                    left[i] = arr[leftStart + i];
                }
                for (int j = 0; j < rightLen; j++) {
                    right[j] = arr[mid + 1 + j];
                }

                int leftPtr = 0, rightPtr = 0, ptr = leftStart;
                while (leftPtr < leftLen && rightPtr < rightLen) {
                    if (left[leftPtr] < right[rightPtr]) {
                        arr[ptr] = left[leftPtr];
                        leftPtr ++;
                    }
                    else {
                        arr[ptr] = right[rightPtr];
                        rightPtr ++;
                    }
                    ptr ++;
                }
                while (leftPtr < leftLen) {
                    arr[ptr] = left[leftPtr];
                    leftPtr ++;
                    ptr ++;
                }
                while (rightPtr < rightLen) {
                    arr[ptr] = right[rightPtr];
                    rightPtr ++;
                    ptr ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,2,8,1,-5,2,1,6,7,-4,-3};
        MergeSort obj = new MergeSort();
        obj.mergeSortRecur(test);
        System.out.println(Arrays.toString(test));

        int[] test1 = new int[]{4,2,8,1,-6,2,1,6,7,-4,-2,7,3};
        obj.mergeSortIter(test1);
        System.out.println(Arrays.toString(test1));
    }
}
