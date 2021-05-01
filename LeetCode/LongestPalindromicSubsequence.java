class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n==0 || n==1)return n;
        char[] ch = s.toCharArray();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)dp[i][i]=1;
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(j-i==1)
                dp[i][j]=ch[i]==ch[j]?2:1;
                else{
                    if(ch[i]==ch[j])
                        dp[i][j]=2+dp[i+1][j-1];
                    else
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
