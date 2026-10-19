class Solution {
    public int maxSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        int a = -1;

        for (int i = 0; i < n; i++) {
            a &= nums[i];

            if (a == 0) {
                count++;
                a = -1;
            }
        }

        return count == 0 ? 1 : count;
    }
}