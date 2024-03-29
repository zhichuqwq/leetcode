## 1、两数之和

[1. 两数之和 - 力扣（LeetCode）](https://leetcode.cn/problems/two-sum/)



## 问题描述

```
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

示例 ：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 
```



## 思路

找两数之和为目标数，很容易想到先选定一个数，然后在数组中查找目标数和它的差值，两个循环就解决了。



#### python code:

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            suu = target - nums[i]
            if suu in nums[i+1:]:
                return [i,nums[i+1:].index(suu)+i+1]
```



#### 复杂度：

- 时间复杂度：O(n^2) 这个在迭代时候用的列表切片比较多，开销挺大的，用哈希表记录一下遇见过的差值可以降低时间复杂度
- 空间复杂度：O(1)
