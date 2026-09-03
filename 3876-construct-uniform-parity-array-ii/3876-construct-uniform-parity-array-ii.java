class Solution {
    public boolean uniformArray(int[] nums1) {

        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        int even = 0, odd = 0;

        for (int num : nums1) {
            if (num % 2 == 0) {
                even++;
                minEven = Math.min(minEven, num);
            } else {
                odd++;
                minOdd = Math.min(minOdd, num);
                maxOdd = Math.max(maxOdd, num);
            }
        }
        if (even == 0 || odd == 0) return true;
        if (minEven > minOdd) return true;
        if (maxOdd < minEven) return true;

        return false;
    }
}