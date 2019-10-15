# cook your dish here
# Computed Longest Palindromic Subsequence,which can be used to compute remaining characters has to be removed

s = input()
n = len(s)
dp = [[1 for i in range(n+1)] for j in range(n+1)]
for i in range(n):
    dp[i+1][i+1]=1

i = n-1
maxi = 1
while i>=1:
    for j in range(i+1,n+1):
        if j-i==1:
            if s[i-1]==s[j-1]:
                dp[i][j]=2
            else:
                dp[i][j]=1
        else:
            if s[i-1]==s[j-1]:
                dp[i][j]=2+dp[i+1][j-1]
            else:
                dp[i][j]=max(dp[i+1][j],dp[i][j-1])
        maxi = max(maxi,dp[i][j])
    i-=1
print(n-maxi)
