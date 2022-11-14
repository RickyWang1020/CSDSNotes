# Sorting Algorithms

Assume we want to sort the array in ascending order, for all following cases.

## Bubble sort

- In every iteration, the largest element in the unsorted subarray will be swapped to very right of the unsorted array and become a sorted part

- Outer loop: `i = 0` to `n-1`, meaning that there are already `i` large numbers "floated" to the end of array

- Inner loop: `j = 0` to `n-i-1`

- Time Complexity: `O(n^2)`

## Merge sort

Time Complexity: `O(nlogn)`

## Heap sort

## Insertion sort

## Selection sort

- Outer loop: `i = 0` to `n-1`, meaning that we now need to find the smallest element from the right subarray and swap it to the i-th position

- Inner loop: `j = i+1` to `n-1`, which is the right subarray

- Time Complexity: `O(n^2)`

## Quick sort

Average Time Complexity: `O(nlogn)`

Worst Time Complexity: `O(n^2)`

## Bucket sort
