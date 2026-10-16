class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int mod = 1_000_000_007;

        int[] freq = new int[n];
        for (int[] req : requests) {
            freq[req[0]]++;
            if (req[1] + 1 < n) {
                freq[req[1] + 1]--;
            }
        }
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(freq);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = (ans + (long) nums[i] * freq[i]) % mod;
        }

        return (int) ans;
    }
}