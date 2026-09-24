class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int target = sum - x;

        if (target < 0) return -1;

        if (target == 0) return n;

        int left = 0;
        int curr = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {

            curr += nums[right];

            while (curr > target && left <= right) {
                curr -= nums[left];
                left++;
            }

            if (curr == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}