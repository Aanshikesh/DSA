
class Solution {
    public boolean threeFibonacciSum(int n) {
        int prev1 = 0;
        int prev2 = 1;
        int curr = 1;

        while (true) {
            int sum = prev1 + prev2 + curr;

            if (sum == n) {
                return true;
            }

            if (sum > n) {
                return false;
            }
            int next = prev2 + curr;
            prev1 = prev2;
            prev2 = curr;
            curr = next;
        }
    }
}
