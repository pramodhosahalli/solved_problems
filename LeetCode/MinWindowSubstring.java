class Solution {
    public String minWindow(String s, String t) {
     
        if(s==null || t==null)return "";
        String res = "";
        int left = 0;
        int count = 0;
        int arr[] = new int[256];
        for(char c : t.toCharArray())arr[c]++;
        int len = s.length();
        int tlen = t.length();
        int minlen = Integer.MAX_VALUE;
        for(int i=0;i<len;i++)
        {
            if(--arr[s.charAt(i)]>=0)count++;
                while(count==tlen)
                {
                    if(i-left+1 < minlen){
                        minlen = i-left+1;
                        res = s.substring(left,i+1);
                    }
                    if(++arr[s.charAt(left)] > 0)count--;
                    left++;
                }
        }
        return res;
    }
}
