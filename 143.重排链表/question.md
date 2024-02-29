## 143. 重排链表

[重排链表](https://leetcode.cn/problems/reorder-list/)



## 题目描述

```
给定一个单链表 L 的头节点 head ，单链表 L 表示为：

L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
```



#### java code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = searchMid(head);
        ListNode head2 = reverseLinkedList(mid);
        while(head2.next != null){
            ListNode list1next = head.next;
            ListNode list2next = head2.next;
            head.next = head2;
            head2.next = list1next;
            head = list1next;
            head2 = list2next;
        }
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextnode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextnode;
        }
        return pre;
    }

    public ListNode searchMid(ListNode head){
        ListNode mid = head,fast = head;
        while(fast != null && fast.next != null){
            mid = mid.next;
            fast = fast.next.next;
        }
        return mid;
    }
}
```

