class Solution {
    public String[] createGrid(int n, int m) {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<m;i++)
        {
            s.append('.');
        }
        String[] ans = new String[n];
        ans[0]=s.toString();
        for(int i=1;i<n;i++)
        {
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<m-1;j++)
            {
                temp.append('#');
            }
            temp.append('.');
            ans[i]=temp.toString();
        }
        return ans;

    }
}