class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int maxint= Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            arr[i] = max(nums[i]);
            maxint = Math.max(maxint, arr[i]);
        }
        int sum =0;
        for(int i =0;i<n;i++){
            if(arr[i]==maxint) sum+=nums[i]; 
        }
        return sum;

    }
    int max(int x){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(x>0){
            int a = x%10;
            max = Math.max(max, a);
            min = Math.min(min, a);
            x/=10;
        }
        return max-min;
    }
}