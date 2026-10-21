class Solution {
    public static long MOD = (long) 1e9 + 7;
    public static long[] fact;
    public static long[] inv;

    static {
        fact = new long[1001];
        inv = new long[1001];

        fact[0] = 1;

        for (int i = 1; i <= 1000; i++)
            fact[i] = mult(fact[i - 1], i);

        inv[1000] = inv(fact[1000]);

        for (int i = 999; i >= 0; i--)
            inv[i] = mult(inv[i + 1], i + 1);
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        int d = Math.abs(startPos - endPos);

        if (d > k || (k - d) % 2 != 0)
            return 0;

        int x = (k + d) / 2;
        int y = (k - d) / 2;

        return (int) mult(fact[k], mult(inv[x], inv[y]));
    }

    public static long mult(long a, long b) {
        a %= MOD;
        b %= MOD;

        return (1L * a * b) % MOD;
    }

    public static long inv(long a) {
        return pow(a, MOD - 2);
    }

    public static long pow(long a, long b) {
        if (b == 0)
            return 1;

        a %= MOD;
        b %= MOD;

        long half = pow(mult(a, a), b / 2);

        return b % 2 == 0 ? half : mult(a, half);
    }
}