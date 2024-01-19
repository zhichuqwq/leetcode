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
