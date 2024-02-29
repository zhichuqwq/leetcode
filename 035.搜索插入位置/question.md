## 35. 搜索插入位置

[ 搜索插入位置](https://leetcode.cn/problems/search-insert-position/)



## 题目描述

```
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。
```



#### java code

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        //还是二分查找
        int left = 0 , right = nums.length-1;
        while(left < right){
            int mid = (left + right)>>1;
            if(nums[mid] == target){
                return mid;
            }
            if(target <= nums[mid]){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        if(target <= nums[right]){return right;}
        else{return right+1;}
    }
}
```

