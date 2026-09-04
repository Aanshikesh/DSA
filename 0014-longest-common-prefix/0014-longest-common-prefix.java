class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        int n = strs.length;
        int i =0;
        while(i<strs[0].length() && i<strs[n-1].length()){
            if(strs[0].charAt(i)==strs[n-1].charAt(i)){ sb.append(strs[0].charAt(i));i++;}
            else break;
        }
        return sb.toString();
    }
}