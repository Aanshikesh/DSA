class Solution {
    public int splitArray(int[] a, int k) {
       return splitarray2(a,a.length,k) ;
    }
    public static int countSum(int[] arr, int sumtotal){
        int size = 1;
        long sumtotalsize =0;
        for(int i = 0;i<arr.length;i++){
            if(sumtotalsize + arr[i] <=sumtotal){
            sumtotalsize+= arr[i];
            }
            else {
                size +=1;
                sumtotalsize = arr[i];
            }

        }
        return size;
    }
    public static int splitarray2(int[] arr , int n , int m){
        if(m>n) return -1;
        int low = Arrays.stream(arr).max().getAsInt();
        int high = 0;
        for(int i=0;i<arr.length;i++){
            high += arr[i];
        }
        while(low<=high){
            int mid = (low+high)/2;
            int size2 = countSum(arr,mid);
            if(size2>m) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}