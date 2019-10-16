func jump(nums []int) int {
    l:= len(nums)
    if l==0 || l==1 {
        return 0
    }
    dp:=make([]int,l)
    dp[0]=0
    for i:=1;i<l;i++ {
        dp[i]=l+1
        for j:=0;j<i;j++ {
            if j+nums[j]>=i && dp[j]+1 < dp[i] {
                dp[i]=dp[j]+1
            }
        }
    }
    return dp[l-1]
}
