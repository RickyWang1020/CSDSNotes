# Bubble Sort
def bubble_sort(lst):
    if not lst:
        return lst
    for i in range(len(lst)):
        # in each iteration, the largest number will go to the end
        for j in range(1, len(lst) - i):
            if lst[j-1] > lst[j]:
                lst[j], lst[j-1] = lst[j-1], lst[j]
    return lst


# Quicksort
def quick_sort(lst):
    if not lst:
        return []
  # always pick the first element in list to be pivot
    pivot = lst[0]
    left = quick_sort([x for x in lst[1:] if x < pivot])
    right = quick_sort([x for x in lst[1:] if x >= pivot])
    return left + [pivot] + right


# Merge Sort
def merge(left, right):
    # assign two pointers to compare and merge two arrays
    l, r, ans = 0, 0, []
    while l < len(left) and r < len(right):
        if left[l] <= right[r]:
            ans.append(left[l])
            l += 1
        else:
            ans.append(right[r])
            r += 1
    ans += left[l:]
    ans += right[r:]
    return ans

def merge_sort(lst):
    if len(lst) <= 1:
        return lst
    mid = len(lst) // 2
    left = lst[:mid]
    right = lst[mid:]
    return merge(left, right)


# Insertion Sort
def insert_sort(lst):
    if not lst:
        return []
    for i in range(1, len(lst)):
        temp = lst[i]
        j = i
        while j > 0 and temp < lst[j-1]:
            lst[j] = lst[j-1]
            j -= 1
        lst[j] = temp
    return lst
 
   
# Heap Sort
def siftup(lst, temp, begin, end):
    # temp: the current "root" value, and it will possibly be swapped downwards
    # begin: the "root" node index for downward sift-up operation
    # end: the ending boundary index for the heap
    if not lst:
        return []
    i, j = begin, begin * 2 + 1
    while j < end:
        # among all children (no grandchild, grand-grandchild,...), pick the largest one to compare with its parent
        # (and exchange with its parent if child_val > parent_val)
        if j + 1 < end and lst[j + 1] > lst[j]:
            j += 1
        elif temp > lst[j]:
            break
        else:
            lst[i] = lst[j]
            i, j = j, 2 * j + 1
    lst[i] = temp

def heap_sort(lst):
    if not lst:
        return []
    end = len(lst)
    # for all non-leaf nodes, perform sift-up (from the second-lowest level to highest)
    # to arrange them into correct max-heap position
    for r in range((end // 2) - 1, -1, -1):
        siftup(lst, lst[r], r, end)
    # every time, "take out" the top of heap (the max in the tree)
    # and perform sift-up to produce the new heap max
    for k in range(end - 1, 0, -1):
        temp = lst[k]
        lst[k] = lst[0]
        siftup(lst, temp, 0, k)
    return lst
        
    
