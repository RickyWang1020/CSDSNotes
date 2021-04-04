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
def 
        
      
