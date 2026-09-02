class Solution {
    public boolean validPalindrome(String s) {
        char[] ch = s.toCharArray();
        int i=0;
        int j=ch.length-1;
        int c=0;
        boolean ans=true;
        while(i<j)
        {
           
            if(ch[i]==ch[j])
            {
                i++;j--;
            }
            else{
                 //System.out.println(i+ " "+j);
                if(c==1)
                {
                    ans= false;
                }
                if(ch[i]==ch[j-1])
                {
                    c++;
                    i++;j-=2;
                }
                else if(ch[i+1]==ch[j])
                {
                    i+=2;j--;
                    c++;
                }
                else{
                    ans= false;
                    i=j;
                }
            }
        }
        if(ans)
        {
            return true;
        }
        boolean ans2=true;
        c=0;
         i=0;
         j=ch.length-1;
        while(i<j)
        {
           
            if(ch[i]==ch[j])
            {
                i++;j--;
            }
            else{
                
                if(c==1)
                {
                    ans2= false;
                }
                
                 if(ch[i+1]==ch[j])
                {
                    i+=2;j--;
                    c++;
                }
                else if(ch[i]==ch[j-1])
                {
                    c++;
                    i++;j-=2;
                }
                else{
                    ans2= false;
                    i=j;
                }
            }
        }
        return ans || ans2;
    }
}