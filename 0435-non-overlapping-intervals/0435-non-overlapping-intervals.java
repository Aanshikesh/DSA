import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        if (arr.length == 0) return 0;

        // Sort by end time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;  // count of non-overlapping intervals
        int lastEndTime = arr[0][1];
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= lastEndTime) {
                count++;
                lastEndTime = arr[i][1];
            }
        }

        return n - count; // number of intervals to remove
    }
}
