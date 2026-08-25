class Solution {
    public int maxProfit(int[] price) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int p : price) {
            minPrice = Math.min(minPrice, p);
            profit = Math.max(profit, p - minPrice);
        }

        return profit;
    }
}