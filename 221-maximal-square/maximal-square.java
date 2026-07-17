class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] mat = new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='1')
                {
                    mat[i][j]=1;
                }
                else{
                    mat[i][j]=0;
                }
                if(i-1>=0 && j-1>=0 &&(mat[i-1][j]!=0 && mat[i][j-1]!=0 && mat[i-1][j-1]!=0 && mat[i][j]!=0))
                {
                    mat[i][j]=1+Math.min(mat[i-1][j-1],Math.min(mat[i-1][j],mat[i][j-1]));
                }
                ans=Math.max(ans,mat[i][j]);
            }
        }
        return ans*ans;
    }
}