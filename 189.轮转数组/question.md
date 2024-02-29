## 189. 轮转数组

[轮转数组](https://leetcode.cn/problems/rotate-array/)



## 题目描述

```
给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
```



#### java code

```java
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){return;}
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

