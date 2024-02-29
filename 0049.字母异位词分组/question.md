## 49. 字母异位词分组

[字母异位词分组](https://leetcode.cn/problems/group-anagrams/)



## 题目描述

```
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
```



#### java code

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> res = new HashMap<>();
        for(String s : strs){
            String code = codeP(s);
            res.putIfAbsent(code, new LinkedList<>());
            res.get(code).add(s);
        }
        List<List<String>> rres = new LinkedList<>();
        for(List<String> group : res.values()){
            rres.add(group);
        }
        return rres;
    }

    public String codeP(String s){
        char[] count = new char[26];
        for(char c : s.toCharArray()){
            int num = c - 'a';
            count[num]++;
        }
        return new String(count);
    }
}
```

