class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0, j = 0;
        java.util.Deque<Integer> mx = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> mn = new java.util.ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!mx.isEmpty() && nums[mx.peekLast()] <= nums[i]) mx.pollLast();
            while (!mn.isEmpty() && nums[mn.peekLast()] >= nums[i]) mn.pollLast();
            mx.addLast(i);
            mn.addLast(i);

            while (j <= i && (long)(nums[mx.peekFirst()] - nums[mn.peekFirst()]) * (i - j + 1) > k) {
                if (mx.peekFirst() == j) mx.pollFirst();
                if (mn.peekFirst() == j) mn.pollFirst();
                j++;
            }
            ans += i - j + 1;
        }
        return ans;
    }
}