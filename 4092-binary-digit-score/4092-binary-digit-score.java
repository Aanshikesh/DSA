class Solution {
    public int calculateScore(int a, int b) {
        int ca = 0, cb = 0;

        while (a > 0) {
            if ((a & 1) == 1) ca++;
            a = a >> 1;
        }

        while (b > 0) {
            if ((b & 1) == 1) cb++;
            b = b >> 1;
        }
        if(ca>=cb) return ca*cb;
        else return cb/ca; 
    }
}