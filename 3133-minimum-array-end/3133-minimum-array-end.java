class Solution {
    public long minEnd(int n, int x) {
        long[] arr = new long[64];
        int a = x;
        n = n-1;
        for (int i = 63; i >= 0; i--) {
            arr[63-i] = a & 1;
            a = a >> 1;
        }

        for(int i = 0;i<64;i++){
           int bit = n%2;
           if(arr[i] == 0){
            //yha change
            arr[i] = bit;
            n = n/2;
           }
        }
        
        long ans = 0;
        for(int i = 0;i<64;i++){
            ans |= 1L*(1L<<i)*arr[i];
        }
        return ans;
    }
}