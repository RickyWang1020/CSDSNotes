// 模版一：当check(mid)==true调整的是left时，取的是靠左方的答案（floor）
// 在[left, right)区间内搜索
long left = 0, right = 1000000;
while (left < right) {
    long mid = left + right + 1 >> 1;
    if (check(mid) == true) {
        left = mid;
    }
    else {
        right = mid - 1;
    }
}


// 模版二：当check(mid)==true调整的是right时，取的是靠右方的答案（ceiling）
// 在(left, right]区间内搜索
long left = 0, right = 1000000;
while (left < right) {
    long mid = left + right >> 1;
    if (check(mid) == true) {
        right = mid;
    }
    else {
        left = mid + 1;
    }
}

// 模版三：在[left, right]区间内搜索
long left = 0, right = 1000000;
while (left <= right) {
    long mid = left + (right - left) / 2;
    if (matrix[mid] < target) {
        left = mid + 1;
    }
    else if (matrix[mid] > target) {
        right = mid - 1;
    }
    else {
        return mid;
    }
}

// 模版四：即使left和right相等的时候也可以检查是否搜索到结果
long left = 0, right = 1000000;
while (left < right) {
    long mid = left + right + 1 >> 1;
    if (matrix[mid] <= target) {
        left = mid;
    }
    else {
        right = mid - 1;
    }
}
if (matrix[right] == target) return true;

