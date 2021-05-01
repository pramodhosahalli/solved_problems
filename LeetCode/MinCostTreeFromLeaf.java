class MinCostTreeFromLeaf {
    public int mctFromLeafValues(int[] arr) {
        int fsum = 0;
        List<Integer> data = new LinkedList<>();
        for(int x : arr) data.add(x);
        
        while(data.size() > 1){
            
            int prod = Integer.MAX_VALUE;
            int index = -1;
            int max = Integer.MAX_VALUE;

            for(int i = 0; i < data.size()-1;i++)
            {
                int val = data.get(i) * data.get(i+1);
                
                if(val < prod){
                    prod = val;
                    max = Math.max(data.get(i),data.get(i+1));
                    index = i;
                    continue;
                }

                if(val == prod  && Math.max(data.get(i),data.get(i+1)) < max){
                    prod = val;
                    max = Math.min(max, Math.max(data.get(i),data.get(i+1)));
                    index = i;
                }
            }
            
            fsum+=prod;
            data.remove(index+1);
            data.set(index,max);
        }
        return fsum;
    }
}

