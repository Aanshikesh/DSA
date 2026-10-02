import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }


        BigInteger num1 = new BigInteger(sb1.toString());
        BigInteger num2 = new BigInteger(sb2.toString());

        BigInteger sum = num1.add(num2);
        System.out.println(sum);

        String s = sum.toString();
        System.out.println(s);
        // Create answer in reverse order
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < s.length(); i++) {
            curr.next = new ListNode(s.charAt(i) - '0');
            curr = curr.next;
        }

        return dummy.next;
    }
}