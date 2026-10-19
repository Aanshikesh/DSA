class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        generate(nums, 0, mid, 0, left);
        generate(nums, mid, n, 0, right);

        Collections.sort(right);

        int ans = Math.abs(goal);

        for (int sum : left) {
            int target = goal - sum;
            int l = 0, r = right.size() - 1;

            while (l <= r) {
                int m = l + (r - l) / 2;
                int total = sum + right.get(m);

                ans = Math.min(ans, Math.abs(goal - total));

                if (total < goal) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return ans;
    }

    void generate(int[] nums, int start, int end, int sum,
                  ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }

        generate(nums, start + 1, end, sum + nums[start], list);
        generate(nums, start + 1, end, sum, list);
    }
}