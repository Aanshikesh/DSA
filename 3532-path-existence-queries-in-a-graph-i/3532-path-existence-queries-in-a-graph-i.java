class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] path = new int[n];
        path[0] = 1;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff) path[i]=1;
        }
        boolean[] ans = new boolean[queries.length];
        int z=0;
        for(int[] query:queries){
            int  a = Math.min(query[0],query[1]);
            int b = Math.max(query[0],query[1]);
            boolean c =true;
            for(int i =a+1;i<=b;i++){
                if(path[i]!= 1) c = false;
            }
            ans[z] = c;
            z++;
        }
        return ans;
    }
}