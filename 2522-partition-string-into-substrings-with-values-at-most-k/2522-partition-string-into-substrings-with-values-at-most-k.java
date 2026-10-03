class Solution {
    public int minimumPartition(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; ) {
            long num = 0;

            while (i < n) {
                int a = s.charAt(i) - '0';

                if (a > k) return -1;

                if (num * 10 + a <= k) {
                    num = num * 10 + a;
                    i++;
                } 
                else {
                    break;
                }
            }

            count++;
        }

        return count;
    }
}