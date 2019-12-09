/* You have d dice, and each die has f faces numbered 1, 2, ..., f.
 * Return the number of possible ways (out of f^d total ways) modulo 10^9 + 7 to roll the dice so the sum of the 
 * face up numbers equals target
 */
 
 // Problem description can be found at https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 
class NoOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int d, int f, int target) {
        
        int[][] dp = new int[d+1][target+1];
        
        for(int i=1;i<=f && i<=target;i++)
            dp[1][i]=1;
        
        for(int i=2;i<=d;i++){
            for(int j=1;j<=target;j++){
                for(int k=1;k<j && k<=f;k++){
                    dp[i][j]=(dp[i][j]+dp[i-1][j-k])%1000000007;
                }
            }
        }
        return dp[d][target];
    }
}
