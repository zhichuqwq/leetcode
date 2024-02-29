## 2670. 找出不同元素数目差数组

[找出不同元素数目差数组](https://leetcode.cn/problems/find-the-distinct-difference-array/)



## 题目描述

```
给你一个下标从 0 开始的数组 nums ，数组长度为 n 。

nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。

返回 nums 的 不同元素数目差 数组。

注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）。特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组。
```



#### java code

```java
class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        HashMap<Integer,Integer> front = new HashMap<>();
        HashMap<Integer,Integer> behind = new HashMap<>();
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            if(!behind.containsKey(nums[i])){
                behind.put(nums[i],1);
            }else{
                behind.put(nums[i],behind.get(nums[i]) + 1);
            }
        }
        for(int i = 0;i < n;i++){
            if(!front.containsKey(nums[i])){
                front.put(nums[i],1);
            }else{
                front.put(nums[i],front.get(nums[i]) + 1);
            }
            behind.put(nums[i],behind.get(nums[i]) - 1);
            if(behind.get(nums[i]) == 0){behind.remove(nums[i]);}
            res[i] = front.size() - behind.size();
        }
        return res;
    }
}
```

