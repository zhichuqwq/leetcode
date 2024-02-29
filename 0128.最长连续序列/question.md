## 128. 最长连续序列

[最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/)



## 题目描述

```
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
```



#### java code

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int res = 0;
        for(int i : set){
            if(set.contains(i - 1)){
                continue;
            }
            int cur = i;
            int len = 1;
            while(set.contains(cur + 1)){
                cur++;
                len++;
            }
            res = Math.max(len , res);
        }
        return res;
    }
}
```

