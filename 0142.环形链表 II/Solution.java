/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> seen = new HashSet<>();
        while(head != null){
            if(!seen.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
