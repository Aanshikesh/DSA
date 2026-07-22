class Solution {
    public boolean isPalindrome(int x) {
    int n = 0;
    if(x<0) return  false;
    int m = x;
    while(m>0){
        n = (n*10 + m%10);
        m = m/10;
    } 
    return n==x;    
    }
}