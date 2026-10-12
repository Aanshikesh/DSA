class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        List<Integer> ans  = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        long sum =0;
        for(int i =2;i<=n;i++){
            boolean flag = true;
            for(int j =2;j*j<=i;j++){
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag && sum+i<=s) {
                ans.add(i);
                sum+=(long)i;
            }
            else if(sum+i>s) return ans;
        }
        
        return ans;
    }
}