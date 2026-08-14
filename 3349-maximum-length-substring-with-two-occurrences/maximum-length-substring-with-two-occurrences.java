class Solution {
    private boolean  check(int[] freq)
    {
        for(int i :freq)
        {
            if(i>2)
            {
                return false;
            }
        }
        return true;
    }
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i=0,j=1;
        int ans=0;
        freq[ch[i]-'a']++;
        while(i<n && j<n)
        {
            freq[ch[j]-'a']++;
            if(check(freq))
            {
                ans=Math.max(ans,j-i+1);
                
            }
            else{
                freq[ch[i]-'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}