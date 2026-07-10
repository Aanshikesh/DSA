class Solution {
    public boolean rotateString(String s, String goal) {
    int n = s.length();
    int m = goal.length();
    if(m!=n) return false;
    if((s+s).contains(goal)) return true;
    return false;     
    }
}