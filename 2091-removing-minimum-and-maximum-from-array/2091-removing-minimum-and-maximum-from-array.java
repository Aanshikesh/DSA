class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minidx = -1;
        int maxidx = -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minidx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxidx = i;
            }
        }

        int left = Math.min(minidx, maxidx);
        int right = Math.max(minidx, maxidx);

        int option1 = right + 1;             
        int option2 = n - left;               
        int option3 = (left + 1) + (n - right); 

        return Math.min(option1, Math.min(option2, option3));
    }
}