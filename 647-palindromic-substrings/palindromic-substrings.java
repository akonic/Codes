class Solution {
    private boolean isPalindrome(char[] ch,int i ,int j)
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
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int n=ch.length;
        int ans=n;
      
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(isPalindrome(ch,i,j))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}