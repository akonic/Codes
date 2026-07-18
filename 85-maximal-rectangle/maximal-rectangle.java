class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='1')
                {
                    int len=Integer.MAX_VALUE;;
                    for(int k=i;k<n;k++)
                    {
                        int l=j;
                        while(l<m && matrix[k][l]=='1')
                        {
                            l++;
                        }
                        len=Math.min(len,l-j);
                        ans=Math.max(ans,len*(k-i+1));

                    }    
                }
            }
        }
        return ans;
    }
}