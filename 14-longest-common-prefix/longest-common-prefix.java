class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int p=strs[0].length();
        for(int i=1;i<n;i++)
        {   int j=0;
            int a=strs[i].length();
            int b=strs[i-1].length();
            while(j<a && j<b && strs[i].charAt(j)==strs[i-1].charAt(j))
            {
                j++;
            }
            p=Math.min(p,j);
        }
        return strs[0].substring(0,p);

    }
}