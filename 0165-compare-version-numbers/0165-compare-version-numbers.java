class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for(int i =0;i<n;i++){
             int s1 = v1.length > i ? Integer.parseInt(v1[i]) : 0;
            int s2 = v2.length > i ? Integer.parseInt(v2[i]) : 0;

            if (s1 > s2) return 1;
            else if (s1 < s2) return -1;
        }
    return 0;
    }
}