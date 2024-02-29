## 3034. 匹配模式数组的子数组数目 I

[匹配模式数组的子数组数目 I](https://leetcode.cn/problems/number-of-subarrays-that-match-a-pattern-i/)



## 题目描述

```
给你一个下标从 0 开始长度为 n 的整数数组 nums ，和一个下标从 0 开始长度为 m 的整数数组 pattern ，pattern 数组只包含整数 -1 ，0 和 1 。

大小为 m + 1 的
子数组
 nums[i..j] 如果对于每个元素 pattern[k] 都满足以下条件，那么我们说这个子数组匹配模式数组 pattern ：

如果 pattern[k] == 1 ，那么 nums[i + k + 1] > nums[i + k]
如果 pattern[k] == 0 ，那么 nums[i + k + 1] == nums[i + k]
如果 pattern[k] == -1 ，那么 nums[i + k + 1] < nums[i + k]
请你返回匹配 pattern 的 nums 子数组的 数目 。
```



#### java code

```java
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int res = 0;
        int n = nums.length,m = pattern.length;
        for(int i = 0;i < n - m;i++){
            int a = i,b = 0;
            while(a < n && b <= m){
                if(b == m){
                    res++;
                    break;
                }
                if(pattern[b] == 1){
                    if(nums[a] >= nums[a + 1]){
                        break;
                    }
                }else if(pattern[b] == 0){
                    if(nums[a] != nums[a + 1]){
                        break;
                    }
                }else{
                    if(nums[a] <= nums[a + 1]){
                        break;
                    }
                }
                a++;
                b++;
            }
        }
        return res;
    }
}
```

