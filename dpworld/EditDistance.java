public class EditDistance {

	/*
	 * Given two strings str1 and str2. We can insert,remove or replace of a character on str1.
	 * Find minimum number of edits (operations) required to convert
	 * ‘str1’ into ‘str2’
	 */

	private static int countEdits(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else {
					if (s1.charAt(i - 1) == s2.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1];
					else
						dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
				}
			}
		}
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		System.out.println(countEdits("sunday", "saturday"));	
	}
	

}
