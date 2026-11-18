class Solution {
    public int minChanges(String s) {
       int n = s.length();
       int ans=0;
       for(int i=0;i<n;i+=2)
       {
          char a = s.charAt(i);
          char b = s.charAt(i+1);
          if(a==b)
          {

          }
          else{
            ans++;
          }
       }
       return ans;
    }
}
/*


0123
*/