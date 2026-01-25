class Solution {
    public int lengthOfLongestSubstring(String s) {
        TreeMap<Character,Integer> mp =new TreeMap<>();
        int n=s.length();
        int ans=0;
        int len=0;
        for(int i=0;i<n;i++)
        {
            Character p = s.charAt(i);
            if(mp.containsKey(p))
            {
                ans=Math.max(len,ans);
                int j = i-len;
                while(mp.containsKey(p))
                {
                    len--;
                    mp.remove(s.charAt(j));
                    j++;
                }
            }
                mp.put(p,1);len++;
        }
        ans=Math.max(len,ans);
        return ans;
    }
}