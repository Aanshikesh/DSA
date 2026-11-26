class Solution {
        public long minCost(int[] A) {
        int n = A.length, cnt = 0;
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            cnt = i > 0 && A[i] == A[i - 1] ? cnt + 1 : 1;
            if (cnt > 1 || (0 < i && i < n - 1)) {
                res = Math.min(res, 1L * (n - cnt) * A[i]);
            }
        }
        return res;
    }
}