class Solution {
    public int[] rearrangeArray(int[] nums) {
        int freq[] = new int[101];
        for(int num:nums){
            freq[num]++;
        }
        int n = nums.length;
        int[] ans = new int[n];
        int idx =0;
        for(int i=0;i<101;i++){
            for(int j =0;j<101;j++){
                if(freq[j]!=0) {
                    freq[j]--;
                    ans[idx++] = j;
                }
            }
        }
        return ans;
    }
}