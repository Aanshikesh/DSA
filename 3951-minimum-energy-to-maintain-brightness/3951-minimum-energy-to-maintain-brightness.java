class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int s = intervals[0][0], e = intervals[0][1];
        long length = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > e) {
                length += (e - s + 1);
                s = intervals[i][0];
                e = intervals[i][1];
            } else {
                e = Math.max(e, intervals[i][1]);
            }
        }
        length += (e - s + 1);
        long ans = 0;
        int bulbOn = (brightness + 2) / 3;
        ans = bulbOn * 1L * length;
        return ans;
    }
}