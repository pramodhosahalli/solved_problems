class BestTimeToBuyWithCoolDown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1)return 0;
        if(n == 2){
            return Math.max(0,prices[1]-prices[0]);
        }
        
        int max = 0;
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(0,dp[i-1]);
             // Good is been selled on i-1th day and ith day is maintained as cooldown
             for(int j = 0; j < i; j++){
                 int val = j > 0 ? dp[j-1] : 0;
                 if(val + prices[i-1] - prices[j] > dp[i])
                     dp[i] = val + prices[i-1] - prices[j];
             }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
