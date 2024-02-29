## 2、两数相加

[2. 两数相加 - 力扣（LeetCode）](https://leetcode.cn/problems/add-two-numbers/description/)



## 题目描述

```
给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照 **逆序** 的方式存储的，并且每个节点只能存储一位数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg)

```
示例：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
```



## 思路

可以递归处理链表的下一个节点，如果两个链表长度不同，就在较短的链表后面添加零节点。最后返回的链表表示两个输入的链表的和。

#### python code：

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
         # 如果其中一个链表为空，则直接返回另一个链表
        if not l1:
            return l2
        if not l2:
            return l1
        # 将当前节点的值相加
        l1.val += l2.val 
        # 如果相加结果大于等于 10，需要进位
        if l1.val >= 10:
            # 如果当前节点没有下一个节点，则创建一个值为 0 的新节点
            if not l1.next:
                l1.next = ListNode(0)
            if not l2.next:
                l2.next = ListNode(0)
            # 取当前节点值的个位部分
            l1.val %= 10
            l1.next.val += 1
            # 递归调用，处理下一个节点
            l1.next = self.addTwoNumbers(l1.next,l2.next)
        else:
            # 如果没有进位，仅递归处理下一个节点
            l1.next = self.addTwoNumbers(l1.next,l2.next)
        return l1
```

#### 复杂度：

- 时间复杂度：O(n) 
- 空间复杂度：O(n) 递归调用的栈深度最多为链表的长度，其他的使用了常数级的额外空间。

