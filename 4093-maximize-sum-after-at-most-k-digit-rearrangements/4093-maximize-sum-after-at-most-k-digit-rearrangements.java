class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        long[][] arr = new long[n][2];

        long sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = getMax(nums[i]);
            sum += nums[i];
        }

        Arrays.sort(arr, (a, b) ->
            Long.compare(a[1] - a[0], b[1] - b[0])
        );

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (arr[i][0] != arr[i][1]) {
                sum += arr[i][1] - arr[i][0];
                k--;
            }
        }

        return sum;
    }

    public long getMax(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);

        long max = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            max = max * 10 + (digits[i] - '0');
        }

        return max;
    }
}