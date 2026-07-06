class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int n = intervals.length;
        int covered = 0;

        for(int i = 0; i < n; i++) {

            boolean isCovered = false;

            for(int j = 0; j < n; j++) {

                if(i == j) continue;

                if(intervals[j][0] <= intervals[i][0] &&
                   intervals[i][1] <= intervals[j][1]) {

                    isCovered = true;
                    break;
                }
            }

            if(isCovered)
                covered++;
        }

        return n - covered;
    }
}