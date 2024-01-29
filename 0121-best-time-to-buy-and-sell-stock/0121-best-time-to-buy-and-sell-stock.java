class Solution {
    public int maxProfit(int[] prices) {
        int maxpro = 0;
        int minpro = Integer.MAX_VALUE;
        for(int i = 0; i<prices.length; i++){
            minpro = Math.min(prices[i] , minpro);
            maxpro = Math.max(maxpro , prices[i] - minpro);
        }
        return maxpro;
    }
}