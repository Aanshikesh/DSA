
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = head;
        ListNode prev = new ListNode(0);
        while(left>1){
            prev = dummy;
            dummy = dummy.next;
            left--;
        }
        ListNode dummy2 = head;
        ListNode prev2 = null;
        while(right>1){
            dummy2 = dummy2.next;
            right--;
        }

        if(dummy2.next!=null) prev2= dummy2.next;

        ListNode reverse = null;
        ListNode cur = dummy;
        while(cur!=prev2 && cur!=null){
            ListNode temp = cur.next;
            cur.next = reverse;
            reverse = cur;
            cur = temp;
        }
        dummy.next = prev2;
        prev.next = dummy2;
        if(prev.val == 0) return prev.next;
        return head;
    }
}