## 45. 跳跃游戏 II

[跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/)



## 题目描述

```
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i] 
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
```



#### java code 

```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0,farest = 0;
        int jump = 0;
        for(int i = 0;i < n - 1;i++){
            farest = Math.max(farest,nums[i] + i);
            if(end == i){
                jump++;
                end = farest;
            }
        }
        return jump;
    }
}
```

