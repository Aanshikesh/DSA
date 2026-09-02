
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        int c =0;
        while(l1!=null && l2!=null){
            int a = l1.val;
            int b = l2.val;
            int sum = a+b+c;
            c = sum/10;
            sum = sum%10;
            ListNode val = new ListNode(sum);
            dummy.next = val;
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int a = l1.val;
            int sum = a+c;
            c = sum/10;
            sum = sum%10;
            ListNode val = new ListNode(sum);
            dummy.next = val;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int a = l2.val;
            int sum = a+c;
            c = sum/10;
            sum = sum%10;
            ListNode val = new ListNode(sum);
            dummy.next = val;
            dummy = dummy.next;
            l2 = l2.next;
        }
        if(c!=0){
            dummy.next = new ListNode(c);
        }
        return ans.next;
    }
}