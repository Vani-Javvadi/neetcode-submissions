class Solution {
    public int maxProfit(int[] prices) {
        // BF - O(N^2) , for every current selling price we will check in left part of array 
        // like on which day we can buy 
        int n = prices.length, minPrice = prices[0], maxProfit=0;
        for(int i=1; i<n; i++) {
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            minPrice = Math.min(prices[i],minPrice);
        }
        return maxProfit;
    }
}
