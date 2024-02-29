## 14. 最长公共前缀

[最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/)



## 题目描述

```
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
```



## 思路

- 把字符串数组当做二维数组来看，行代表保存的哪一个字符串，列代表这个位置的字符串的字符，然后按列循环对比就行。



#### java code：

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i = 0;i < strs[0].length();i++){
            for(int j = 1;j < strs.length;j++){
                if(i >= strs[j].length() || i >= strs[j-1].length() || strs[j].charAt(i) != strs[j-1].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
```



#### 复杂度

- 时间复杂度：O(N*M)  N 是字符串数组的长度，M 是数组中最短字符串的长度。
- 空间复杂度：O(1)