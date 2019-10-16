//Problem Description can be found at https://leetcode.com/problems/decode-ways/
class Solution {
    public int numDecodings(String s) {
     
     int len = s.length();
     if(len >= 1 && s.charAt(0)=='0')return 0;
     if(len==0 || len==1)return len;        
     int[] count = new int[len+1];   
     count[0]=1;
     count[1]=1;
        
     for(int i=2;i<=len;i++){
         if(s.charAt(i-1)=='0' && (s.charAt(i-2)=='0' || s.charAt(i-2)>='3'))
             return 0;
         if(s.charAt(i-1)=='0')
             count[i]=count[i-2];
         else if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1) < '7'))
             count[i]=count[i-1]+count[i-2];
         else
             count[i]=count[i-1];
      }
        return count[len];
    }
}
