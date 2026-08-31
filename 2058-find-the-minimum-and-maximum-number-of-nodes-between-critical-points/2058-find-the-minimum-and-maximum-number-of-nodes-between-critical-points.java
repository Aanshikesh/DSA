class Solution {
    public boolean isCritical(ListNode prev, ListNode curr) {
        return (curr.val > prev.val && curr.val > curr.next.val) ||
               (curr.val < prev.val && curr.val < curr.next.val);
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1}; 
        }
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        int first = -1; 
        int last = -1;  
        int idx = 1;     
        int minDist = Integer.MAX_VALUE; 
        int maxDist = -1;  
        int count = 0;   
        
        while (curr.next != null) {
            if (isCritical(prev, curr)) {
                count++;
                
                if (first == -1) {  
                    first = idx;
                } else { 
                    minDist = Math.min(minDist, idx - last);
                }
                
                last = idx; 
            }
            
            prev = curr;
            curr = curr.next;
            idx++;
        }

        if (count < 2) {
            return new int[]{-1, -1}; 
        }
        
        maxDist = last - first;  
        return new int[]{minDist, maxDist};
    }
}
