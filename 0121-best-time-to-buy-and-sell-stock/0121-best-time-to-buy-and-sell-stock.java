class Solution {
    public int maxProfit(int[] price) {
        int n = price.length;

        if (n <= 1) return 0;

        int[] min = new int[n];
        int[] max = new int[n];

        min[0] = price[0];
        max[n - 1] = price[n - 1];

        for (int i = 1; i < n - 1; i++) {
            min[i] = Math.min(min[i - 1], price[i]);
            max[n - i - 1] = Math.max(price[n - i - 1], max[n - i]);
        }

        min[n - 1] = Math.min(min[n - 2], price[n - 1]);
        max[0] = Math.max(price[0], max[1]);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, max[i] - min[i]);
        }

        return ans;
    }
}