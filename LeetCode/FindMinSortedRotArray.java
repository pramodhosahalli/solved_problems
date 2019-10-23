import java.io.*;
import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        int l = nums.length;
        if(l==1)return nums[0];
        if(l==2)return Math.min(nums[0],nums[1]);
        
        int low = 0;
        int high = l-1;
        
        while(low < high)
        {
            int mid = (low+high)>>1;
            if(mid==low || mid==high)
                break;          
            
            if(nums[mid]==nums[low] && nums[mid]==nums[high]){
                low+=1;
                high-=1;
                continue;
            }
            if(nums[mid] <= nums[low] && nums[mid] <= nums[high]){
                //move towards larger
                if(nums[low] < nums[high])
                    low = mid;
                else
                    high = mid;
            }
            else{
                //move towards smaller
                if(nums[low] < nums[high])
                    high = mid;
                else
                    low = mid;
            }            
        }
        return Math.min(nums[low],nums[high]);
    }
}
