class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
     int max =0;
     int l =0 , r = n-1;
     while(l<r){
        int water = Math.min(height[l] , height[r])*(r-l);
        max = Math.max(water, max);
        if(height[l]<=height[r]) l++;
        else r--;
     }
     return max;
    }
}