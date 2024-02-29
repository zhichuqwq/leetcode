## 2808. 使循环数组所有元素相等的最少秒数

[使循环数组所有元素相等的最少秒数](https://leetcode.cn/problems/minimum-seconds-to-equalize-a-circular-array/)



## 题目描述

```
给你一个下标从 0 开始长度为 n 的数组 nums 。

每一秒，你可以对数组执行以下操作：

对于范围在 [0, n - 1] 内的每一个下标 i ，将 nums[i] 替换成 nums[i] ，nums[(i - 1 + n) % n] 或者 nums[(i + 1) % n] 三者之一。
注意，所有元素会被同时替换。

请你返回将数组 nums 中所有元素变成相等元素所需要的 最少 秒数。
```



#### java code

```java
class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer , List<Integer>> mp = new HashMap<>();
        int n = nums.size(),res = n;
        for(int i = 0;i < n;i++){
            mp.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        for(List<Integer> list : mp.values()){
            int maxdis = list.get(0) + n - list.get(list.size() - 1);
            for(int i = 1;i < list.size();i++){
                maxdis = Math.max(maxdis , list.get(i) - list.get(i - 1));
            }
            res = Math.min(maxdis / 2,res);
        }
        return res;
    }
}
```

