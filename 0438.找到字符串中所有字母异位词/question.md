## 438.找到字符串中所有字母异位词

[找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)



## 题目描述

```
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
```



#### java code

```java
/*
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length(),llen = s.length();
        char[] comp = code(p);
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < llen - len + 1;i++){
            String ss = s.substring(i , i + len);
            char[] sss = code(ss);
            if(Arrays.equals(sss,comp)){
                res.add(i);
            }
        }
        return res;
    }

    public char[] code(String s){
        char[] count = new char[26];
        for(char c : s.toCharArray()){
            int i = c - 'a';
            count[i]++;
        }
        return count;
    }
}
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}

```

