class Solution {
    static int mod=(int)(1e9+7);
    static class SegTree{
        int n;
        int arr[];
        long seg[];
        long segx[];
        int segn[];//no of digits in range

        SegTree(int arr[]){
            this.arr=arr;this.n=arr.length;
            seg=new long[4*n];
            segx=new long[4*n];
            segn=new int[4*n];
            build(0,0,n-1);
        }
        void build(int ind,int low,int high){
            if(low==high){
                seg[ind]=arr[low];

                if(arr[low]>0){
                    segn[ind]=1;
                    segx[ind]=arr[low];
                }
                return ;
            }
            int mid=(low+high)>>1;
            build(2*ind+1,low,mid);
            build(2*ind+2,mid+1,high);
            seg[ind]=seg[2*ind+1]+seg[2*ind+2];
            
            segn[ind]=segn[2*ind+1]+segn[2*ind+2];
            segx[ind]=segx[2*ind+1]*modpow(10,segn[2*ind+2])%mod+segx[2*ind+2];
            //x = leftX * 10^(rightN) + rightX
        }
        long modpow(long base,int exp){
            long res=1;
            while(exp>0){
                if((exp&1)==1)res=res*base%mod;
                base=base*base%mod;
                exp>>=1;

            }
            return res;

        }
        long []q(int ind,int low,int high,int left,int right){

            if (high < left || low > right) return new long[]{0, 0, 0};//out of league

             if (low >= left && high <= right) {//lie 
                return new long[]{seg[ind], segx[ind], segn[ind]};
            }
            int mid=(low+high)>>1;
            long leftside[]=q(2*ind+1,low,mid,left,right);
            long []rightside=q(2*ind+2,mid+1,high,left,right);

            long sum=leftside[0]+rightside[0];
            long n=leftside[2]+rightside[2];
            long x=(leftside[1]*modpow(10,(int)rightside[2])%mod+rightside[1])%mod;

            return new long[]{sum,x,n};
        }

    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        //seg tree storing digit sum range

        int n=s.length();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=s.charAt(i)-'0';
        }
        SegTree st=new SegTree(nums);
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            
            long res[]=st.q(0,0,n-1,queries[i][0],queries[i][1]);
            ans[i]=(int)((res[0]*res[1])%mod);

        }
        return ans;
    }
}