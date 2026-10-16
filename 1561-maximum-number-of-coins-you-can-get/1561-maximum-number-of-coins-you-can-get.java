class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int count =n/3;
        int ans =0;
        for(int i=n-2;i>=0;i-=2){
            if(count>0){
                ans += piles[i];
                count--; 
            }
        }
        return ans;
    }
}