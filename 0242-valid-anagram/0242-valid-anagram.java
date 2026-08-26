class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        
        if(n!=t.length()) return false;

        int[] freqs = new int[26];
        int[] freqt = new int[26];
        for(int i=0;i<n;i++){
            freqs[s.charAt(i)-'a']++;
            freqt[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freqs[i]!=freqt[i]) return false;
        }
        return true;
    }
}