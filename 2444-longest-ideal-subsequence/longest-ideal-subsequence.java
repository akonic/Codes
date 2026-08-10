class Solution {
    private int helper(char[] ch,int i,int prev,int k)
    {
        if(i>=ch.length)
        {
            return 0;
        }
        int pick=0,skip=0;
        if(prev==0)
        {
            pick=1+helper(ch,i+1,i,k);
        }
        else if(Math.abs(ch[prev-1] - 'a' - (ch[i-1]-'a'))<=k)
        {
            pick=1+helper(ch,i+1,i,k);
        }
        skip=helper(ch,i+1,prev,k);

        return Math.max(skip,pick);
    }
    public int longestIdealString(String s, int k) {
        char[] ch = s.toCharArray();
        int n= ch.length;
        //return 1+helper(ch,1,0,k);
        int[] dp = new int[n];
        int[] freq = new int[26];
        int[] till = new int[26];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<26;j++)
            {
                if(freq[j]>0 && Math.abs(ch[i]-'a' - j)<=k)
                {
                    dp[i]=Math.max(dp[i],1+till[j]);
                }
            }
            freq[ch[i]-'a']++;
            till[ch[i]-'a']=dp[i];
            ans=Math.max(ans,dp[i]);
        }
        return 1+ans;
    }
}