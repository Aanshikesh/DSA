class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            st.add(nums[i]);
        }
        int a =0;
        while(true){
            a = a+k;
            if(!st.contains(a)) return a;
        }
    }
}