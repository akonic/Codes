class Solution {
    private int helper(int[][] matrix,int[] ones,List<Integer> ls)
    {
        int ans=0;
        
        for(int i=0;i<matrix.length;i++)
        {
            int c=0;
            for(int j : ls)
            {
                if(matrix[i][j]==1)
                {
                    c++;
                }
            }
            if(c==ones[i])
            {
                ans++;
            }
        }
          return ans;
        
    }

    private int check(int[][] matrix, int[] ones, int i, int numSelect, List<Integer> ls) {
        if (numSelect == 0) {
            return helper(matrix, ones, ls);
        }
        if(i>=matrix[0].length)
        {
            return Integer.MIN_VALUE;
        }
        int x=0,y=0;
        ls.add(i);
        x=check(matrix,ones,i+1,numSelect-1,ls);
        int p =ls.size();
        ls.remove(p-1);
        y=check(matrix,ones,i+1,numSelect,ls);

        return Math.max(x,y);
    }

    public int maximumRows(int[][] matrix, int numSelect) {
        int n = matrix.length;
        int m=matrix[0].length;
        int[] ones = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            ones[i] = count;
        }
        List<Integer> ls = new ArrayList<>();
        return check(matrix, ones, 0, numSelect, ls);
    }
}