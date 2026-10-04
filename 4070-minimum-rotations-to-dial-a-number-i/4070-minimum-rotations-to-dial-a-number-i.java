class Solution {
    public int minRotations(String s) {
        int a3 = s.charAt(0) - '0';
        int aa = 10-a3;
        int ans = Math.min(a3, aa);

        for (int i = 1; i < s.length(); i++) {
            int b = s.charAt(i) - '0';
            int a = s.charAt(i - 1) - '0';

            int a1 = Math.abs(b - a);
            int a2 = 10 - a1;

            ans += Math.min(a1, a2);
        }

        return ans;
    }
}