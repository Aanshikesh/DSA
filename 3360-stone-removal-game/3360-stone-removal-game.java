class Solution {
    public boolean canAliceWin(int n) {
        int a = 10;
        boolean aliceTurn = true;

        while (n >= a) {
            n -= a;
            a--;
            aliceTurn = !aliceTurn; 
            if (a == 0) break; 
        }
        return !aliceTurn; 
    }
}
