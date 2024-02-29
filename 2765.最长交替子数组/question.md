## 2765. 最长交替子数组

[最长交替子数组](https://leetcode.cn/problems/longest-alternating-subarray/)



## 题目描述

```
给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：

m 大于 1 。
s1 = s0 + 1 。
下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。

子数组是一个数组中一段连续 非空 的元素序列。
```



#### java code

```java
class Solution {
    public int alternatingSubarray(int[] nums) {
        if(nums.length <= 1){return -1;}
        int res = -1,cur = 1;
        boolean flag = true;
        for(int i = 0,j = 1;j < nums.length;i++,j++){
            if(flag){
                if(nums[i]-nums[j] == -1){
                    cur++;
                    res = Math.max(res,cur);
                    flag = !flag;
                }else{
                    cur = 1;        
                }
            }else{
                if(nums[i]-nums[j] == 1){
                    cur++;
                    res = Math.max(res,cur); 
                }else{ 
                    i--;
                    j--;
                    cur = 1;   
                }
                flag = true;
            }
        }
        return res;
    }
}
```

