## 28. 找出字符串中第一个匹配项的下标

[ 找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/)



## 题目描述

```
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回 -1 。

示例 1：

输入：haystack = "sadbutsad", needle = "sad"
输出：0
解释："sad" 在下标 0 和 6 处匹配。
第一个匹配项的下标是 0 ，所以返回 0 。

示例 2：

输入：haystack = "leetcode", needle = "leeto"
输出：-1
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
```



## 思路

这个题目暴力解和KMP算法都行，但直接暴力做出来意义不大了，实现一下KMP。

- next数组的构建
  1. next数组构建完全是由匹配串得出来的，与原串无关。我们用两个指针 j 从 0 位置开始，i 从 1 位置开始对比。
  2. 若p[i] == p[j]，就让next[i] = j+1 然后 i 和 j 同时加一
  3. 若p[i] != p[j]，就让j = next[j - 1]，整个对比的过程循环进行直到 i = p.length()
- 匹配过程
  1. 同样两个指针 i j都从  位置开始，i 是原串的指针它不会回退，j是匹配串的指针，匹配失败后会根据next数组进行回退
  2. 若y[i] == p[j]，当前位置匹配成功，i 和 j 同时加一
  3. 若y[i] != p[j]，匹配失败，让 j = next[i - 1]，整个匹配的过程同样循环进行
  4. 如果 j == p.length() 匹配成功，返回 i - p.length() +1
  5. 若原串遍历结束后，j != p.length()，说明没有匹配的串，返回-1  

#### java code：

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int plen = haystack.length();
        int[] next = new int[len];
        next[0] = 0;
        // 构建next数组，i = 1 j = 0开始
        for (int i = 1, j = 0; i < len; i++) {
            // 匹配失败的时候j=next[j-1]
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                next[i] = j + 1;
                j++;
            }
        }
        // 匹配过程
        for (int i = 0, j = 0; i < plen; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == len) {
                return i - len + 1;
            }
        }
        return -1;
    }
}
```



#### 复杂度

- 时间复杂度：O(n)
- 空间复杂度：O(m+n) m是匹配串的长度，n是原串的长度