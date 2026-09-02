class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.put(nums[i], 1);
        }
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            int x = nums[i];
            if (set.containsKey(x)) {
                int left = x - 1;
                while (set.containsKey(left)) {
                    set.remove(left);
                    count++;
                    left--;
                }
                int right = x + 1;
                while (set.containsKey(right)) {
                    set.remove(right);
                    count++;
                    right++;
                }

            }
            count++;
            max = Math.max(max, count);
        }

        return max;
    }
}