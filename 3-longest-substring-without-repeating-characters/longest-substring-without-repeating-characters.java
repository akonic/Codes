class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int n=s.length();
        if(n==0)
        {
            return 0;
        }
        int ans=1;
        int i=0,j=1;
        Arrays.fill(map,0);
        map[s.charAt(i)]++;
        while(j<n)
        {
            char c=s.charAt(j);
            while(map[c]!=0)
            {
                map[s.charAt(i)]--;i++;
            }
            map[c]++;
            ans=Math.max(ans,j-i+1);
            j++;
        }

        return ans;
    }
}