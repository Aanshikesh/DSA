class Solution {
    public int maxPoints(int[][] points) {
        
        int ans = 0;
        int n = points.length;
        if(n<=2) return n;
        for (int i = 0; i < n; i++) {
            int count = 1;
            TreeMap<Double, Integer> mp = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                if (points[j][0] - points[i][0] != 0 && i!=j) {
                    double slope = (double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]);
                    mp.put(slope, mp.getOrDefault(slope, 0) + 1);
                }
                if(points[j][0] - points[i][0] == 0 && i!=j) count++;
            }
            int maxFreq = Integer.MIN_VALUE;
            System.out.println(mp);
            for (Map.Entry<Double, Integer> entry : mp.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                }
            }
            ans = Math.max(maxFreq+1, Math.max(count,ans));

        }
        return ans;
    }
}