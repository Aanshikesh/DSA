class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int s = 0;
        int e = 0;
        for (int w : weights) {
            s = Math.max(s, w);
            e += w;
        }
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int day = solve(weights, n, mid);
            if (day <= days)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }

    private int solve(int[] weights, int n, int mid) {
        int days = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + weights[i] > mid) {
                days++;
                sum = weights[i];
            } else
                sum += weights[i];

        }
        return days;
    }
}