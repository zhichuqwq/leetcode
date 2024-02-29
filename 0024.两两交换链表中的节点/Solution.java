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
