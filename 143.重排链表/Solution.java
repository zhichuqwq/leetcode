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
