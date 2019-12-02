# Problem Description can be found at https://www.hackerrank.com/challenges/largest-rectangle/problem


static long largestRectangle(int[] h) {
        
        long maxvalue = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<h.length;i++){
            while(!stack.isEmpty() && h[i] < h[stack.peek()]){
                int index = stack.pop();
                maxvalue = Math.max(maxvalue,(long)(stack.isEmpty()?i:i-(stack.peek()+1))*h[index]);
            }
            stack.push(i);
        }
            while(!stack.isEmpty()){
                int index = stack.pop();
                maxvalue = Math.max(maxvalue,(long)(stack.isEmpty()?h.length:h.length-(stack.peek()+1))*h[index]);
            }
        return maxvalue;
    }
