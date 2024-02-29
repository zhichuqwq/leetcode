## 26. 删除有序数组中的重复项

[ 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)



## 题目描述

```
给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
返回 k 。

示例 1：

输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

示例 2：

输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
```



## 思路

- 也是使用双指针解决，用一个指针标记当前不重复元素的位置。然后用另一个指针循环遍历整个数组，判断当前元素是否和前一个不重复元素相同，不相同就说明这是一个新的不重复元素。
- 找到新的不重复元素后更新指针位置，同时增加不重复元素个数的计数，遍历结束后返回结果。



#### java code：

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        int num = 1;
        for(int i = 1;i < nums.length ;i++){
            if(nums[i] != nums[uniqueIndex]){
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
                num++;
            }
        }
        return num;
    }
}
```



#### 复杂度

- 时间复杂度：O(n)
- 空间复杂度：O(1)

