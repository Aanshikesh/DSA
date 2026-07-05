class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        if (k >= n) return -1;

        int max = Integer.MIN_VALUE;

        int[] p = new int[n];
        p[0] = nums[0];

        for (int i = 1; i < n; i++) {
            p[i] = Math.max(p[i - 1], nums[i]);
        }

        for (int i = k; i < n; i++) {
            max = Math.max(max, nums[i] + p[i - k]);
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}