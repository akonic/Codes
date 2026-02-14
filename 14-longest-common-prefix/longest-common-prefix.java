class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int x=strs[0].length();
        int n=strs.length;
        for(int i=1;i<n;i++)
        {
            int p=0;
            for(int j=0;j<x;j++)
            {
                if(strs[0].charAt(j)==strs[i].charAt(j))
                {
                    p++;
                }
                else{
                    j=210;
                }
            }
            x=Math.min(x,p);
        }

        return strs[0].substring(0,x);
    }
}