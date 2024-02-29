## 27. 移除元素

[移除元素](https://leetcode.cn/problems/remove-element/)



## 问题描述

```
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 ：

输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
```



## 思路

1. `unique` 是一个索引变量，表示当前不等于特定值 `val` 的元素的位置。
2. 使用 `for` 循环遍历整个数组 `nums`。
3. 在循环中，通过条件语句 `if(nums[i] != val)` 检查当前元素是否等于特定值 `val`。如果不等于，说明找到了一个不需要移除的元素。
4. 将当前元素放置在 `unique` 的位置，并递增 `unique`。
5. 循环结束后，返回 `unique`，即不包含特定值 `val` 的新数组的长度。



#### java code：

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int unique = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] != val){
                nums[unique] = nums[i];
                unique++;
            }
        }
        return unique;
    }
}
```



#### 复杂度

- 时间复杂度：O(n)
- 空间复杂度：O(1)