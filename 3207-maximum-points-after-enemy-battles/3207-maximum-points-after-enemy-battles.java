import java.util.*;

class Solution {
    public long maximumPoints(int[] ee, int ce) {
        Arrays.sort(ee);

        int i = 0, j = ee.length - 1;
        long points = 0;

        while (i <= j) {
            if (ce >= ee[i]) {
                int gain = ce / ee[i];   
                points += gain;
                ce -= gain * ee[i];
            } 
            else if (points > 0) {
                ce += ee[j--];
            } 
            else {
                break;
            }
        }
        return points;
    }
}