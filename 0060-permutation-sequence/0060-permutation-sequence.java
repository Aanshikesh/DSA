class Solution {
    HashSet<Integer>st = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    int nn;
    int find(int n){
        int ans = 1;
        for(int k = n;k>=1;k--) ans*=k;
        return ans;
    }
    void solve(int i,int k){
        if(i>=nn) return;

        for(int j = 1;j<=nn;j++){
            if(st.contains(j)) continue;
            int cnt = find(nn-i-1);
            if(cnt>=k){
                st.add(j);
                sb.append(j);
                solve(i+1,k);
            }
            k-=cnt;
        }
    }
    public String getPermutation(int n, int k) {
        nn = n;
        solve(0,k);
        return sb.toString();
    }
}