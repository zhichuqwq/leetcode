## 24. 两两交换链表中的节点

[两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/)



## 题目描述

```
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

 

示例 1：

输入：head = [1,2,3,4]
输出：[2,1,4,3]
```



#### java code

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){return head;}
        if(head.next.next == null){
            head.next.next = head;
            ListNode per = head.next;
            head.next = null;
            return per;
        }
        ListNode res = head.next;
        ListNode nextnode = head.next.next;
        head.next.next = head;
        head.next = swapPairs(nextnode);
        return res;
    }
}
```

