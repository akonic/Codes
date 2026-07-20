class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        k=(k)%(n*m);
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++)
            temp[i] = grid[i].clone();
        while (k > 0) {
            k--;
            int[][] temp2 = new int[n][m];
            for (int i = 0; i < n; i++)
                temp2[i] = temp[i].clone();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m-1; j++) {
                    temp2[i][j+1]=temp[i][j];
                }
            }
            for(int i=0;i<n-1;i++)
            {
                temp2[i+1][0]=temp[i][m-1];
            }
            temp2[0][0]=temp[n-1][m-1];

            temp=temp2;

            // for(int i=0;i<n;i++)
            // {
            //     for(int j=0;j<m;j++)
            //     {
            //         System.out.println(temp2[i][j]);
            //     }
            // }
            // System.out.println("------------------");
        }
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> lp = new ArrayList<>();
            for(int j : temp[i])
            {
                lp.add(j);
            }
            ls.add(lp);
        }

        return ls;
    }
}