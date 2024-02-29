## 283. 移动零

[移动零](https://leetcode.cn/problems/move-zeroes/)



## 题目描述

```
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。
```



#### java code

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int i : nums){
            if(i != 0){
                nums[slow] = i;
                slow++;
            }
        }
        Arrays.fill(nums,slow,nums.length,0);
    }
}
```

