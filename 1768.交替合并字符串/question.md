## 1768. 交替合并字符串

[交替合并字符串](https://leetcode.cn/problems/merge-strings-alternately/)



## 题目描述

```
给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。

返回 合并后的字符串 。
```



#### java code

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] word1array = word1.toCharArray();
        char[] word2array = word2.toCharArray();
        StringBuilder res = new StringBuilder();
        int m = word1array.length,n = word2array.length;
        int i = 0, j = 0;
        while(i < m || j < n){
            if(i < m){
                res.append(word1array[i]);
                i++;
            }
            if(j < n){
                res.append(word2array[j]);
                j++;
            }
        }
        return res.toString();
    }
}
```

