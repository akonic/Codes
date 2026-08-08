class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans=Integer.MAX_VALUE;
        int n = matrix.length;
       
        for(int i=1;i<n;i++)
        {   
           for (int j=0;j<n;j++)
           {
                int p=matrix[i-1][j];
                if(j-1>=0)
                {
                    p=Math.min(p,matrix[i-1][j-1]);
                }
                if(j+1<n)
                {
                    p=Math.min(p,matrix[i-1][j+1]);
                }

                matrix[i][j]+=p;
           }
        }
        for(int i=0;i<n;i++)
        { 
            ans=Math.min(ans,matrix[n-1][i]);
        }
        return ans;
    }
}