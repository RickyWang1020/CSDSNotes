// 模版一：当check(mid)==true调整的是left时，取的是靠左方的答案（floor）
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

// 二分搜索模版：即使left和right相等的时候也可以检查是否搜索到结果
long left = 0, right = 1000000;
while (left < right) {
    long mid = left + right + 1 >> 1;
    if (matrix[mid] >= target) {
        left = mid;
    }
    else {
        right = mid - 1;
    }
}
if (matrix[right] == target) return true;

