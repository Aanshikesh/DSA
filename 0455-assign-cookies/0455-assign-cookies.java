class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int j=0;
        int i =0;
        while(i<g.length){
            if(j<s.length){
                if(g[i]<=s[j]){
                    count++;
                    j++;
                    i++;
                }
                else j++;
            }
            else break;
        }
        return count;
    }
}