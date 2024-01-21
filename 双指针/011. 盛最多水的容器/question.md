## 11. 盛最多水的容器

[11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/)



## 题目描述

```
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
```

![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg)

```
示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49 
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
```



## 思路

- 双指针，分别从容器的左边界和右边界出发，比较左右指针所指的线的长度，每次都更新较短线的指针位置，然后时刻更新最大容量，直到左右指针遍历完数组，返回最大容量。



#### python code：

```python
class Solution:
    def maxArea(self, height: List[int]) -> int:
        left , right, res = 0 , len(height)-1, 0
        while left < right:
            if height[right] > height[left]:
                res = max(res,(right - left)* height[left])
                left += 1
            else:
                res = max(res,(right - left)* height[right],)
                right -=1
        return res
```



#### 复杂度

- 时间复杂度：O(N)
- 空间复杂度：O(1)