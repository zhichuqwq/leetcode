## 41. 缺失的第一个正数

[缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/)



## 题目描述

```
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
```



#### java code

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0;i < len;i++){
            if(nums[i] <= 0){
                nums[i] = len + 1;
            }
        }
        for(int i = 0;i < len;i++){
            int num = Math.abs(nums[i]);
            if(num <= len){
                nums[num - 1] = - Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}

```

