## 5. 最长回文子串

[最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/)



## 题目描述

```
给你一个字符串 `s`，找到 `s` 中最长的回文子串。
如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"
```



## 思路

找回文串核心是找回文串的核心，然后从中间向两边扩散，这题主要解决一下回文串长度是奇数和偶数的情况。

这里用'searchre'方法，传入查找串的中心位置的left和right指针，向两边扩散寻找最长回文串。通过控制left和right是否相同，实现查找偶数和奇数回文串。 

#### java code：

```java
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0;i <= s.length()-1 ;i++){
            String s1 = searchre(s,i,i);
            String s2 = searchre(s,i,i+1);
            //分别查找最长回文串是单数和双数的情况
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
            }
        return ans;
        } 
    
    //双指针两边扩散寻找最长的回文串
    //修改这个函数让返回值为回文串起始位置下标和长度应该可以缩短函数的执行时间
    public String searchre(String s,int left,int right){
        while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }
        //脱离循环后需要回退一步到满足条件的回文串，让left+1，right-1
        return s.substring(left+1 , right);
    }
}
```



#### 复杂度

- 时间复杂度：O(n^2)
- 空间复杂度：O(1)