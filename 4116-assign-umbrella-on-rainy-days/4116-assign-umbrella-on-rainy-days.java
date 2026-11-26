class Solution {
    public String[] assignUmbrella(int[] rain) {
        String s1 = "Alice";
        String s2 = "Bob";
        String s3 = "None";
        int a =0;
        int b =0;
        int n = rain.length;
        
        String[] ans = new String[n];
        if(n==1 && rain[0]!=0) {
            ans[0]  = s2;
            return ans;
        }
        for(int i=0;i<n-1;i++){
            if(rain[i]==rain[i+1] && rain[i]!=0){
                if(a<=b) {
                    ans[i] = s1;
                    a++;
                }
                else {
                    ans[i] = s2;
                    b++;
                }
            }
            else if(rain[i]==0){
                ans[i] = s3;
            }
            else{
                ans[i]=s2;
                b++;
            }
        }
        if(rain[n-1]!=0)ans[n-1] = s2;
        else ans[n-1] = s3;
        return ans;
    }
}