class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[][] pre1 = new int[51][n];
        int[][] pre2 = new int[51][n];

        for(int i=0;i<=50;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {
                if(A[j]==i)
                {
                    c++;
                }
                pre1[i][j]=c;            
            }
        }
        for(int i=0;i<=50;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {
                if(B[j]==i)
                {
                    c++;
                }
                pre2[i][j]=c;            
            }
        }

        int[] ans= new int[n];

        for(int i=0;i<n;i++)
        {
            int p=0;
            for(int j=0;j<=50;j++)
            {
                if(pre1[j][i]!=0 && pre2[j][i]!=0)
                {
                    p++;
                }
            }
            ans[i]=p;
        }
        return ans;
        
    }
}