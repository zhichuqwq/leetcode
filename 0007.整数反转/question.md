## 7. 整数反转

[7. 整数反转](https://leetcode.cn/problems/reverse-integer/)



## 题目描述

```
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。

示例 1：

输入：x = 123
输出：321

示例 2：

输入：x = -123
输出：-321
```



## 思路

- 把整数转换为字符串，然后用字符串切片实现翻转，最后判断范围检查正负以后就可以输出了。



#### python code：

```python
class Solution:
    def reverse(self, x: int) -> int:
        n = str(abs(x))[::-1]
        m = int(n)
        if -2**31 <= m <= 2**31-1:
            if x > 0:return m
            else: return -m
        else:return 0

```



#### 复杂度

- 时间复杂度：O(log(x))
- 空间复杂度：O(log(x))