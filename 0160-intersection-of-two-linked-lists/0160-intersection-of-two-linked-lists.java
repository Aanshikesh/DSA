/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 =0;
        int n2 =0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1!=null){
            n1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            n2++;
            temp2 = temp2.next;
        }

        if(n1>n2){
            while(n1-n2>0){
                headA = headA.next;
                n1--;
            }
        }
        else{
             while(n2-n1>0){
                headB= headB.next;
                n2--;
            }
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}