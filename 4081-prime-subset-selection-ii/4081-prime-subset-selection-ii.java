class Solution {

    private int solve(int idx, int sum, List<Integer> primes, int[][] dp) {
        if (sum == 0) return 0;
        if (idx == primes.size() || sum < 0) {
            return 1000000000;
        }

        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }

        // Don't take the current prime
        int notTake = solve(idx + 1, sum, primes, dp);

        // Take the current prime
        int take = 1000000000;
        if (primes.get(idx) <= sum) {
            take = 1 + solve(idx + 1, sum - primes.get(idx), primes, dp);
        }

        return dp[idx][sum] = Math.min(take, notTake);
    }

    public List<Integer> maxPrimeSubset(int n, int s) {
        List<Integer> ans = new ArrayList<>();

        if (s < 2) return ans;

        // Sieve of Eratosthenes
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Store all primes
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int size = primes.size();
        int[][] dp = new int[size + 1][s + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Find the maximum achievable sum <= s
        int maxiSum = s;

        while (maxiSum >= 2 &&
               solve(0, maxiSum, primes, dp) >= 1000000000) {
            maxiSum--;
        }

        if (maxiSum < 2) return ans;

        // Reconstruct the subset
        int idx = 0;
        int sum = maxiSum;

        while (idx < size && sum > 0) {
            int take = 1000000000;

            if (primes.get(idx) <= sum) {
                take = 1 + solve(idx + 1, sum - primes.get(idx), primes, dp);
            }

            int notTake = solve(idx + 1, sum, primes, dp);

            if (take <= notTake) {
                ans.add(primes.get(idx));
                sum -= primes.get(idx);
            }

            idx++;
        }

        return ans;
    }
}