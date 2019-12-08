# Problem description can be found at https://leetcode.com/problems/maximal-rectangle/

class MaximalRectangle {
    
    	public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)return 0; 
        int[] hist = new int[matrix[0].length];
        int maxarea  = 0;
        for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]=='1')hist[j]++;
            else hist[j]=0;
          }
          maxarea = Math.max(maxarea, getMaxArea(hist));
        }
        return maxarea;
	 }

      private int getMaxArea(int[] hist) {
        int maxarea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<hist.length;i++){
          while(!stack.isEmpty() && hist[stack.peek()] > hist[i]){
            int index = stack.pop();
            maxarea = Math.max(maxarea, (stack.isEmpty()?i:(i-stack.peek()-1))*hist[index]);
          }
          stack.push(i);
        }
        while(!stack.isEmpty()){
          int index = stack.pop();
          maxarea = Math.max(maxarea, (stack.isEmpty()?hist.length:(hist.length-stack.peek()-1))*hist[index]);
        }
        return maxarea;
      }
}
