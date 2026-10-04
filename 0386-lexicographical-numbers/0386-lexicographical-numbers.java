class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for (int j = 1; j <= 9; j++) {
            solve(j, n, ans);
        }

        return ans;
    }

    public void solve(int num, int n, List<Integer> ans) {
        if (num > n) return;

        ans.add(num);

        for (int k = 0; k <= 9; k++) {
            int next = num * 10 + k;

            if (next > n) break;

            solve(next, n, ans);
        }
    }
}