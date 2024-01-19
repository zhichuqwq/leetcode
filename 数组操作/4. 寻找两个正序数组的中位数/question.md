## 4. 寻找两个正序数组的中位数

[ 寻找两个正序数组的中位数 - 力扣（LeetCode）](https://leetcode.cn/problems/median-of-two-sorted-arrays/description/)



## 题目描述

```
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。
算法的时间复杂度应该为 O(log (m+n)) 。

示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
```



## 思路

1. 初始化一个空数组 `nums3`，以及两个指针 `i` 和 `j` 分别指向 `nums1` 和 `nums2` 的起始位置。
2. 使用 `while` 循环合并两个已排序的数组。比较当前指针位置的元素，将较小的元素添加到 `nums3` 中，然后移动相应的指针。
3. 将剩余部分直接添加到 `nums3`。这是因为如果两个数组的长度不同，合并后可能有一个数组还有剩余元素。
4. 计算合并后数组的长度 `length`。
5. 如果 `length` 为奇数，直接返回中间位置的元素；如果为偶数，返回中间两个元素的平均值。



#### python code：

```python
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # num3存放合并之后的数组，i，j是读取两个数组的指针
        nums3 , i , j = [] , 0 , 0
        #合并数组
        while i < len(nums1) and j <len(nums2):
            if nums1[i]<nums2[j]:
                nums3.append(nums1[i])
                i+=1
            else:
                nums3.append(nums2[j])
                j+=1
        #一个数组读取结束后把另一个数组剩余的元素直接加到num3上
        nums3.extend(nums1[i:])
        nums3.extend(nums2[j:])
        length = len(nums3)
        if length % 2:
        # 如果数组长度为偶数，取中间两个数的平均值
            return nums3[length // 2 ]
        else:
        # 如果数组长度为奇数，直接取中间的数
            return (nums3[length // 2 - 1] + nums3[length // 2 ]) / 2
```



#### 复杂度

- 时间复杂度：O(m + n)
- 空间复杂度：O(m + n)

