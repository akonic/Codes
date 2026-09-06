class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int ans=0,k=0;
        char[][] ch = new char[n][m];
        for(String s : strs)
        {
            ch[k]=s.toCharArray();k++;
        }
        for(int j=0;j<m;j++)
        {
            boolean flag=false;
            for(int i=1;i<n;i++)
            {
                if(ch[i][j]<ch[i-1][j])
                {
                    flag=true;
                    i=n;
                }
            }
            if(flag)
            {
                ans++;
            }
        }
        return ans;
    }
}