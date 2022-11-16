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

Time Complexity: `O(nlogn)`

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

## Quick sort

Average Time Complexity: `O(nlogn)`

Worst Time Complexity: `O(n^2)`

## Bucket sort
