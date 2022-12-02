# Sorting Algorithms

Assume we want to sort the array in ascending order (from small to large), for all following cases.

## Bubble sort

- In every iteration, the largest element in the unsorted subarray will be swapped to very right of the unsorted array and become a sorted part

- Outer loop: `i = 0` to `n-1`, meaning that there are already `i` large numbers "floated" to the end of array

- Inner loop: `j = 0` to `n-i-1`

- Time Complexity: `O(n^2)`

## Selection sort

- Outer loop: `i = 0` to `n-1`, meaning that we now need to find the smallest element from the right subarray and swap it to the i-th position

- Inner loop: `j = i+1` to `n-1`, which is the right subarray

- Time Complexity: `O(n^2)`

## Merge sort

- Divide and conquer: split the array into half, perform merge sort on the two subarrays, and merge the two sorted subarrays into one sorted array

- Iterative: start from subarrays of length 1, and merge them by pairs, until reach the full array

- Time Complexity: `O(nlogn)`

## Heap sort

- Also see notes on [heap](https://github.com/RickyWang1020/CSDSNotes/tree/master/Java/Algorithms/heap)

- Heapify: start from the given root of a subtree, compare and swap downwards to maintain a heap structure

- Heap sort: 

  - Build a heap: from the original array, only heapify the non-leaf nodes in reversed order (bottom-up heapify)
  
  - Remove the root node (current smallest/largest element) and put the last element of array as the new root
  
  - Repeat the steps until the heap is empty
  
- In-place implementation: build a max-heap, every time swap the root node with the last element in heap, so that the largest element is at the end of array

- Time Complexity: `O(nlogn)`

## Insertion sort

- Idea: iterate through each number, compare this number with every number prior to it (i.e., already sorted), and insert this into the proper index

- Implementation: use "swap"/"overwrite" instead of "insert"

- Time Complexity: `O(n^2)`

## Quick sort

- Randomly pick a pivot every iteration, swap all elements <= pivot to the left of the pivot, and swap all elements > pivot to the right of the pivot, repeat the process for left and right subarrays, until the subarray only has 1 element

- Average Time Complexity: `O(nlogn)`, Worst Time Complexity: `O(n^2)`

- Why is quick sort better than merge sort in arrays?

  - Quick sort is in-place, while Merge sort requires `O(n)` extra space

## Bucket sort

- Create `k` buckets, and put elements into the buckets, and sort each (non-empty) bucket using any stable sorting algorithm

- Useful when the data are uniformly distributed over a certain range

- Average Time Complexity: `O(n)` if `n ≈ k`, Worst Time Complexity: `O(n^2)` or `O(nlogn)` when all data are in one bucket
