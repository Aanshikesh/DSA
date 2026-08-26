
class Solution {
    public ListNode reverseList(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    
    while(head!=null){
        stack.push(head.val);
        head = head.next;
    }
    if (stack.isEmpty()) return null;

    ListNode ans = new ListNode(stack.pop());
    ListNode ans2 = ans;
      while (!stack.isEmpty()) {
            ans.next = new ListNode(stack.pop());
            ans = ans.next;
        } 
    return ans2; 
    }
}