## 34. 在排序数组中查找元素的第一个和最后一个位置

[在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)



## 题目描述

给你一个按照非递减顺序排列的整数数组 `nums`，和一个目标值 `target`。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 `target`，返回 `[-1, -1]`。

你必须设计并实现时间复杂度为 `O(log n)` 的算法解决此问题。

 

**示例 1：**

```
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
```

**示例 2：**

```
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
```



#### java code：

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //分两次分别查找第一个等于target的数的数组下标和第一个大于target的数的数组下标
        int left = search(nums , target);
        int right = search(nums , target+1);
        if(left == nums.length || nums[left] != target){return new int[]{-1,-1};}
        return new int[]{left,right-1};
    }
    
    public int search(int[] nums , int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left + right)>>1;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
```



#### 复杂度

- 时间复杂度：O(log n)
- 空间复杂度：O(1)