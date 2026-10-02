class Solution {
    public int[] numsSameConsecDiff(int n, int k) {

        Set<Integer> st = new HashSet<>();

        // Start with digits 1 to 9
        for (int first = 1; first <= 9; first++) {

            StringBuilder sb = new StringBuilder();
            sb.append(first);

            build(sb, n, k, st);
        }

        int[] ans = new int[st.size()];
        int idx = 0;

        for (int x : st) {
            ans[idx++] = x;
        }

        return ans;
    }

    public void build(StringBuilder sb, int n, int k, Set<Integer> st) {

        // Number is complete
        if (sb.length() == n) {
            st.add(Integer.parseInt(sb.toString()));
            return;
        }

        int last = sb.charAt(sb.length() - 1) - '0';

        // Case 1: last + k
        if (last + k <= 9) {
            sb.append(last + k);

            build(sb, n, k, st);

            sb.deleteCharAt(sb.length() - 1);
        }

        // Case 2: last - k
        if (last - k >= 0) {
            sb.append(last - k);

            build(sb, n, k, st);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}