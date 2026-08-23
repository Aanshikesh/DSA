class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int a = (int)s.charAt(i);
            String binary = String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0');
            sb.append(binary);


        }
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        if(s1.equals(s2)) return true;
        return false;
    }
}