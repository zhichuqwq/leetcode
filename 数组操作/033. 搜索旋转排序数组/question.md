## 33. 搜索旋转排序数组

[搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/)



## 题目描述

```
整数数组 nums 按升序排列，数组中的值互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你旋转后的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
```



## 思路 

- 看到要求时间复杂度为 O(log n) 大概就猜到可以用二分查找
- 直接对数组使用二分查找以后可以发现，每次分割都可以使数组分为一边有序另一边部分有序，可以通过判断num[left],num[mid],num[right]的值可以判断那边有序，哪边无序。然后判断target是在有序侧还是无序侧，以此为依据更新左右指针。



#### java code：

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            //0到mid一侧为有序排列的一侧
            if(nums[0] <= nums[mid]){
                //target在有序的一侧时，更新右指针
                if(nums[mid] > target && target >= nums[0]){
                    right = mid - 1;
                }
                //target在无序的一侧时，更新左指针
                else{
                    left = mid + 1;
                }
            }
            //mid到nums.length-1的一侧有序
            else{
                //target在有序的一侧时，更新左指针
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }
                //target在无序的一侧时，更新右指针
                else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
```



#### 复杂度

- 时间复杂度：O(log n)
- 空间复杂度：O(1)