class Solution {
    public String largestOddNumber(String num) {
    int a =-1;
    int n =  num.length();
    for(int i=n-1;i>=0;i-- ){
        if(num.charAt(i)%2!=0) {
        a=i;
        break;
        }
    } 
    if (a ==-1) return num.substring(0, 0) ;  
     return num.substring(0, a+1);
    }
}