class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] arr) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        if(m==1 && n==1 && arr[0][0]==1)return 0;
        int[][] dp = new int[m][n];
        
        for(int i=0;i<n;i++){
            if(arr[0][i]!=1){
                if(i==0)dp[0][i]=1;
                else
                    dp[0][i]=dp[0][i-1];
            }
            
        }
        
        for(int i=1;i<m;i++){
            if(arr[i][0]!=1){
                dp[i][0]=dp[i-1][0];
            }
        }
        
        for(int i=1;i<m;i++)
        for(int j=1;j<n;j++){
            if(arr[i][j]!=1)
            dp[i][j]=dp[i][j-1]+dp[i-1][j];
        }
        
        if(arr[m-1][n-1]==1)return 0;
        return dp[m-1][n-1];
    }
}
