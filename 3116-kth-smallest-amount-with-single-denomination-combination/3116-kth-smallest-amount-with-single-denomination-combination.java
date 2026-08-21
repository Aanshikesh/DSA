import java.util.*;

class Solution {

    List<Integer> coins;
    int n;

    private long gcd(long a, long b){
        while(b != 0){
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }

    private long countSmaller(long x){
        long ans = 0;

        for(int mask = 1; mask < (1 << n); mask++){
            long lcm = 0;
            int cnt = 0;

            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0){
                    cnt++;

                    if(lcm == 0) lcm = coins.get(i);
                    else lcm = lcm(lcm, coins.get(i));
                }
            }

            if(cnt % 2 == 0) ans -= x / lcm;
            else ans += x / lcm;
        }

        return ans;
    }

    public long findKthSmallest(int[] c, int k) {

        coins = new ArrayList<>();
        for(int coin : c) coins.add(coin);

        n = coins.size();

        long l = 1, r = (long)1e18;

        while(l < r){
            long m = (l + r) >> 1;

            if(countSmaller(m) >= k) r = m;
            else l = m + 1;
        }

        return l;
    }
}