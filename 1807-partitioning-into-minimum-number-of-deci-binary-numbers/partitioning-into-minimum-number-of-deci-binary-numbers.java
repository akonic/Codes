class Solution {
    public int minPartitions(String n) {
        char[] p = n.toCharArray();
        int x=p.length;
        int ans=0;
        for(int i=0;i<x;i++)
        {
            ans=Math.max(p[i]-'0',ans);
        }
        return ans;
    }
}