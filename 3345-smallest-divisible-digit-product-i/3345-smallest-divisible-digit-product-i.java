class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while (true) {
            if (product(i) % t == 0) {
                return i;
            }
            i++;
     
        }
    }

    private int product(int num) {
        int prod = 1;
        while (num > 0) {
            int digit = num % 10;
             prod *= digit;
            num /= 10;
        }
        return prod;
    }
}
