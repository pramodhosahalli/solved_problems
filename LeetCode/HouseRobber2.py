#problem description can be found at https://leetcode.com/problems/house-robber-ii/

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        if len(nums)==1:
            return nums[0]
        if len(nums)==2:
            return max(nums[0],nums[1])
        dp1 = [0] * (len(nums)-1)
        dp2 = [0] * (len(nums)-1)
        dp1[0]=nums[0]
        dp1[1]=max(nums[0],nums[1])
        for i in range(2,len(nums)-1):
            dp1[i]=max(dp1[i-1],dp1[i-2]+nums[i])
        dp2[0]=nums[1]
        dp2[1]=max(nums[1],nums[2])
        for i in range(2,len(nums)-1):
            dp2[i]=max(dp2[i-1],dp2[i-2]+nums[i+1])
        return max(dp1[len(nums)-2],dp2[len(nums)-2])
        
