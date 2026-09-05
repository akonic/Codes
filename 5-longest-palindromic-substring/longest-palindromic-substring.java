class Solution {
    private boolean check(char[] ch,int i,int j)
    {
        while(i<j)
        {
            if(ch[i]!=ch[j])
            {
                return false;
            }
            i++;j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int ans=0;
        String st ="";
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(check(ch,i,j) && j-i+1>ans)
                {
                    ans=j-i+1;
                    StringBuilder p = new StringBuilder();
                    for(int u=i;u<=j;u++)
                    {
                        p.append(ch[u]);
                    }
                    st = p.toString();
                }
            }
        }
        return st;
    }
}