//Problem Description can be found at https://leetcode.com/problems/search-a-2d-matrix-ii/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0)return false;
        int n = matrix[0].length;
        
        int i = m-1;
        int j = 0;
        
        while(i>=0 && j < n)
        {
            int ele = matrix[i][j];
            if(ele==target)return true;
            
            if(matrix[i][j] < target)j++;
            else
                i--;
        }
        return false;
    }
}
