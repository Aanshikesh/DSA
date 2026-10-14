class Solution {
    public String maxSumOfSquares(int num, int sum) {
      int[] freq = new int[10];
      int s = sum;
      int a =9;
      while(s>0){
        if(s-a>=0){
            freq[a]++;
            s-=a;
        }
        else a--;
      }  
      a=0;
      for(int i=0;i<10;i++){
        a+=freq[i];
      }
      if(a>num) return "";
      if(a<num) freq[0] = num-a;
      StringBuilder sb = new StringBuilder();
      for(int i=9;i>=0;i--){
            while(freq[i]>0){
                sb.append(i);
                freq[i]--;
            }
      }
      return sb.toString();
    }
}