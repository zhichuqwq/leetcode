## 55. 跳跃游戏

[跳跃游戏](https://leetcode.cn/problems/jump-game/)



## 题目描述

```
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
```



#### java code

```java
class Solution {
    public boolean canJump(int[] nums) {
        int farest = 0,end = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            farest = Math.max(farest,nums[i] + i);
            if(end == i){
                end = farest;
            }
        }
        if(end >= n - 1){
            return true;
        }
        return false;
    }
}
```

