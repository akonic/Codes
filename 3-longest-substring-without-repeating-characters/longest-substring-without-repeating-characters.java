class Solution {
    public int lengthOfLongestSubstring(String s) {
        TreeMap<Character,Integer> mp =new TreeMap<>();
        int n=s.length();
        int ans=0;
        int len=0;
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(s.charAt(i)))
            {
                ans=Math.max(len,ans);
                int j = i-len;
                while(mp.containsKey(s.charAt(i)))
                {
                    len--;
                    mp.remove(s.charAt(j));
                    j++;
                }
            }
                mp.put(s.charAt(i),1);len++;
        }
        ans=Math.max(len,ans);
        return ans;
    }
}