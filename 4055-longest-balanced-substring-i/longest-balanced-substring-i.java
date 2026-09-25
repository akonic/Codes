class Solution {
    private boolean check(int[] freq)
    {
        int i=0,p=0;
        while(i<26 && p==0)
        {
            if(freq[i]!=0)
            {
                p=freq[i];
                break;
            }
            i++;
        }
        while(i<26)
        {
            if(freq[i]>0 && freq[i]!=p)
            {
                return false;
            }
            i++;
        }
        return true;
    }
    public int longestBalanced(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int ans=1;
        for(int i=0;i<n;i++)
        {
            int[] freq = new int[26];
            for(int j=i;j<n;j++)
            {
                freq[ch[j]-'a']++;
                if(check(freq))
                {
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}