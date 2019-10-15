//Problem Description can be found at https://leetcode.com/problems/132-pattern/

class Solution {
// O(n^2) Approach...Took 479ms
    public boolean find132pattern(int[] arr) {
        if(arr.length < 3)return false;
        int[] dp = new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=1;i<arr.length-1;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                        dp[i]=Math.min(dp[i],arr[j]);
                }
            }
        }
        for(int i=1;i<arr.length-1;i++)
            if(dp[i]!=Integer.MAX_VALUE)
                for(int j=i+1;j<arr.length;j++)
                    if(arr[j] < arr[i] && arr[j] > dp[i])
                        return true;
        return false;
    }
   
// O(nlogn) Approach...Took 17ms
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        if(n < 3)return false;
        
       TreeSet<Integer> treeSet = new TreeSet<>();
       int[] minStorer = new int[n];
       minStorer[0]=nums[0];
        
       for(int i=1;i<n;i++)
       minStorer[i]=Math.min(minStorer[i-1],nums[i]);
        
       treeSet.add(nums[n-1]); 
       for(int i=n-2;i>=1;i--) {
           if(nums[i]!=minStorer[i]){
               //find next minimum element greater than minStorer[i]
        	   Integer ele = treeSet.higher(minStorer[i]);
        	   if(ele!=null && nums[i] > ele)return true;
           }
           treeSet.add(nums[i]);
       }
        return false;
    }
}
