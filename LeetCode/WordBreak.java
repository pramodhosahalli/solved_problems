class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
     
        int l = s.length();
        boolean[] dp = new boolean[l+1];
        dp[0]=true;
        
        for(int i=1;i<=l;i++)
        {
            for(int j=i;j<=l;j++){
                    String ss = s.substring(i-1,j);
                    if(wordDict.contains(ss))
                        dp[j]=dp[j-ss.length()] || dp[j];
            }
        }
        return dp[l];
    }
}
