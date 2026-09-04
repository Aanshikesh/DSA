class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int b = needle.length();
        int count = 0; 
        for (int i = 0; i < n; i++) {
            if (haystack.charAt(i) == needle.charAt(count)) {
                count++; 
            if (count == b) return (i - count + 1);  } 
            else {
                if (count > 0) {
                    i -= count; 
                }
                count = 0;
            }
        }
        return -1; 
    }
}
