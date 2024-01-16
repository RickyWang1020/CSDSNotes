## 二分查找特定值模版

### 查找小于x的第一个数
若是查找不到，即所有的数都大于等于target，此时根据if (nums[mid] >= target) r = mid - 1，范围会向左收缩，一直到查找范围中下标最小点，l = r 返回
```
def findFirstSmallerThanX():
    l = 0
    r = n - 1
    while l < r:
        mid = (l + r + 1) // 2
        if nums[mid] >= target:
            r = mid - 1
        else:
            l = mid
    return r
```

### 查找等于x的第一个数
```
def findFirstEqualX():
    l = 0
    r = n - 1
    while l < r:
        mid = (l + r) // 2
        if nums[mid] < target:
            l = mid + 1
        else:
            r = mid
    return r
```

### 查找等于x的最后一个数
若查找不到（所有数都小于等于x），则返回最大下标值
```
def findLastEqualX():
    l = 0
    r = n - 1
    while l < r:
        mid = (l + r + 1) // 2
        if nums[mid] > target:
            r = mid - 1
        else:
            l = mid
    return r
```

### 查找大于x的第一个数
```
def findFirstLargerThanX():
    l = 0
    r = n - 1
    while l < r:
        mid = (l + r) // 2
        if nums[mid] <= target:
            l = mid + 1
        else:
            r = mid
    return r
```
