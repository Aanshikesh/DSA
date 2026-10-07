class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;

        int[] odd = new int[100001];
        int[] even = new int[100001];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[nums[i]]++;
            } else {
                odd[nums[i]]++;
            }
        }

        int evenMax = 0, evenSecond = 0;
        int oddMax = 0, oddSecond = 0;
        int evenVal = -1, oddVal = -1;

        for (int i = 0; i <= 100000; i++) {
            if (even[i] > evenMax) {
                evenSecond = evenMax;
                evenMax = even[i];
                evenVal = i;
            } else if (even[i] > evenSecond) {
                evenSecond = even[i];
            }

            if (odd[i] > oddMax) {
                oddSecond = oddMax;
                oddMax = odd[i];
                oddVal = i;
            } else if (odd[i] > oddSecond) {
                oddSecond = odd[i];
            }
        }

        if (evenVal != oddVal) {
            return n - evenMax - oddMax;
        }

        return n - Math.max(
            evenMax + oddSecond,
            evenSecond + oddMax
        );
    }
}