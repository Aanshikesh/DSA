class Solution {
    public int countGoodRotations(int[] nums) {

        int n = nums.length;
        int count = 0;

        int leftS = 0;
        int rightS = 0;

        int left = n / 2;

        // Initial split
        for (int i = 0; i < left; i++) {
            leftS += nums[i];
        }

        for (int i = left; i < n; i++) {
            rightS += nums[i];
        }

        for (int i = 0; i < n; i++) {

            if (leftS > rightS) {
                count++;
            }

            // Move to next rotation
            int outgoingLeft = nums[(i) % n];
            int incomingLeft = nums[(i + left) % n];

            leftS = leftS - outgoingLeft + incomingLeft;
            rightS = rightS - incomingLeft + outgoingLeft;
        }

        return count;
    }
}