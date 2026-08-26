class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb  = new StringBuilder();
        for(char ch : s.toCharArray()){
                if((ch>='a' && ch<='z') || (ch >= '0' && ch <= '9')) sb.append(ch);
                else if((ch>='A' && ch<='Z')) sb.append((char)((int)ch +32));
                else continue;
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}