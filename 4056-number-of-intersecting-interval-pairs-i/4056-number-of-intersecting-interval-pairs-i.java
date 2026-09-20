class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int e = intervals[i][1];
            int s = 0, end = n - 1;
            while (s <= end) {
                int mid = s + (end - s) / 2;
                if (intervals[mid][0] <= e) {
                    s = mid + 1;
                } else
                    end = mid - 1;
            }
            count += (s - i - 1);
        }

        return count;

    }
}