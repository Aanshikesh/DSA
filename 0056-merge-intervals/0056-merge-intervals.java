import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] arr) {
        if (arr.length == 0) return new int[0][];
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        for (int[] interval : arr) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}