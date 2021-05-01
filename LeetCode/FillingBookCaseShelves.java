class FillingBookCaseShelves {
    public int minHeightShelves(int[][] books, int sw) {
        
        int n = books.length;
        int[] dp = new int[n]; // Indicates min height to place first i books...
        
        //Just place First Book
        dp[0] = books[0][1];
        
        for(int i = 1; i < n; i++)
        {
            int w = books[i][0];
            int h = books[i][1];
            
            //we can place ith book in new-row or in existing row
            
            //if we place in new row height increase by h.... (dp[i-1] + h)
            dp[i] = dp[i-1] + h;
            
            //say if we try to accumulate this book in previous row
            int j = i - 1;
            while(j >= 0 && books[j][0] + w <= sw)
            {
                w+=books[j][0];
                h = Math.max(h,books[j][1]);
                dp[i] = Math.min(dp[i], (j > 0 ? dp[j-1] : 0) + h);
                j--;
            }
        }
        return dp[n-1];
    }
}
