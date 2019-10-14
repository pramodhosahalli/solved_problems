# problem description can be found at https://leetcode.com/problems/container-with-most-water/

class Solution:
    def maxArea(self, arr: List[int]) -> int:
        if len(arr)==0 or len(arr)==1:
            return 0
        l = 0
        h = len(arr)-1
        maxstored = 0
        while(l < h):
            distance = h-l
            maxstored = max(maxstored, distance*min(arr[l],arr[h]))
            if arr[l] <= arr[h]:
                l+=1
            else:
                h-=1
        return maxstored
