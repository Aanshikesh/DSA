class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int freq[] = new int[2002];
        for(int num:arr){
            freq[num+1000]++;
        }
        Set<Integer> st = new HashSet<>();
        for(int i =0;i<2002;i++){
            if(freq[i]==0) continue;
            else if(st.contains(freq[i])) return false;
            else st.add(freq[i]);
        }
        return true;
    }
}