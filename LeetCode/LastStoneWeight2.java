class LastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int x : stones) sum+=x;
        boolean[] dp = new boolean[sum+1];
        boolean[] copy = new boolean[sum+1];
        dp[0] = true;
        
        for(int x : stones){
            for(int i = 0; i<=sum; i++) copy[i] = dp[i];
            for(int i = x; i <= sum; i++){
                if(copy[i-x]) dp[i] = true;
            }
        }
        
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i<=sum/2;i++){
            if(dp[i] && dp[sum-i])
                diff = Math.min(diff,(sum-2*i));
        }
        return diff;
    }
}

