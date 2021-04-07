#!/usr/bin/env python3
def binary_search(arr, element):
    left = 0
    right = len(arr) - 1
    while left <= right:
        mid = (right + left) // 2
        # continue searching on the right side
        if element > arr[mid]:
            left = mid + 1
        # continue searching on the left side
        elif element < arr[mid]:
            right = mid - 1
        # found
        else:
            return mid
    return -1
