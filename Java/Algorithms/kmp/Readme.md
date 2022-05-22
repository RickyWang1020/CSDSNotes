# KMP Algorithm

### Features

- Time Complexity: `O(m+n)`, where n is the length of whole string, m is the length of substring wanted to search for
- KMP能在「非完全匹配」的过程中提取到有效信息进行复用，以减少「重复匹配」的消耗
- 利用了prefix（前缀）和suffix（后缀）的概念
- implementation中，可以在string和substring的开头加上sentinel node，防止越界

### Steps

举例：string = `ababcabcabababd`, substring_to_match = `ababd`

1. 为substring_to_match构建匹配表`next`
  - 两个指针i和j，i在前j在后
  - If `substring_to_match[j] == substring_to_match[i]`, `next[i] = j + 1`, increment both i and j
  - Else, if `substring_to_match[j] != substring_to_match[i]`, continue to invoke `j = next[j - 1]`（取next数组中当前j对应的元素，这里-1只是为了index转换）, until `substring_to_match[i] == substring_to_match[j]` or `j == 0`
    - If there is some j that makes `substring_to_match[i] == substring_to_match[j]`, then `next[i] = j + 1`
    - Else, `next[i] = 0`
  - In the example, the `next` table is `0 0 1 2 0`.

2. 将匹配表`next`与string进行比较，查看是否有匹配
  - 利用`next`可跳转的性质，如果匹配不上则跳转到`next`中对应的元素的位置

### References

[1] https://leetcode.cn/problems/implement-strstr/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/ 包含构建匹配表和kmp
[2] https://www.youtube.com/watch?v=V5-7GzOfADQ 但是没有讲构建匹配表，只讲了kmp
