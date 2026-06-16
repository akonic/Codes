class Solution {
    public String processStr(String s) {
        int n=s.length();
        String ans="";
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z')
            {
                ans+=ch;
            }
            else if(ch=='*')
            {
                if(ans.length()>=1){
                String cleanText = ans.substring(0, ans.length() - 1);
                ans=cleanText;}
            }
            else if(ch=='#')
            {
                ans+=ans;
            }
            else if(ch=='%')
            {
                String reversed = new StringBuilder(ans).reverse().toString();
                ans=reversed;
            }
        }
        return ans;
    }
}