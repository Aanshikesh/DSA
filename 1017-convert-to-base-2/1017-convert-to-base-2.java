class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        if(n==0) return "0";
        while (n != 0) {
            int x = n % (-2);

            if (x < 0) {
                x += 2;
                n = n / (-2) + 1;
            } else {
                n /= -2;
            }

            sb.append(x);
        }

        sb.reverse();
        return (sb.toString());
    }
}