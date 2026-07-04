class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        int max = 0;

        for (int i = 0; i < n; i++) st.add(nums[i]);

        for (int i = 0; i < n; i++) {
            int a = nums[i];
            int count = 0;

            while ((long) a * a <= Integer.MAX_VALUE && st.contains((int) ((long) a * a))) {
                count++;
                a = (int) ((long) a * a);
            }

            max = Math.max(count, max);
        }

        if (max >= 1) return max + 1;
        return -1;
    }
}