## 二分查找特定值模版

### Theory（找大于等于某个数字的第一个index）

- 
- 闭区间、一开一闭、开区间皆可

#### 闭区间 [L, R]
- 初始化L为0，R为length-1，M = (L + R) // 2
- 循环条件：区间不为空，则L <= R都可以循环
- 如果M的数字 < target，意味着[L, M]区间内的数字都 < target，需要移动L = M + 1来搜索[M+1, R]区间
- 如果M的数字 >= target，意味着[M, R]区间内的数字都 >= target，需要移动R = M - 1来搜索[L, M-1]区间
- 跳出循环后，R+1或L都代表结果
```python
def lowerBound(x):
    l = 0
    r = n - 1
    while l <= r:
        mid = (l + r) // 2
        if nums[mid] < target:
            l = mid + 1
        else:
            r = mid - 1
    return l 
```

#### 左开右闭 [L, R)

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
