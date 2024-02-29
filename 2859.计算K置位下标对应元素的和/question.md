## 2859. 计算 K 置位下标对应元素的和

[计算 K 置位下标对应元素的和](https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/)



## 题目描述

```
给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。

请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。

整数的二进制表示中的 1 就是这个整数的 置位 。

例如，21 的二进制表示为 10101 ，其中有 3 个置位。
```



#### java code

```java
class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for(int i = 0;i < nums.size(); i++){
            if(bitCount(i) == k){
                res += nums.get(i);
            }
        }
        return res;
    }

    public int bitCount(int i){
        int res = 0;
        while(i != 0){
            res += (i % 2);
            i /= 2;
        }
        return res;
    }
}
```

