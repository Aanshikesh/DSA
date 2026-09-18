class Solution {
    public long shadowPairs(int[] nums) {

        long ops = 0;

        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[i] < st.peek()) {

                int top = st.peek();

                mpp.put(top, mpp.get(top) - 1);
                st.pop();
            }

            ops += st.size() - mpp.getOrDefault(nums[i], 0);

            st.push(nums[i]);
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        return ops;
    }
}