class Solution {
    List<List<String>> ans = new ArrayList<>();

    private void build(boolean[][] row) {

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                if (row[i][j]) {
                    s.append('Q');
                } else {
                    s.append('.');
                }
            }
            ls.add(s.toString());
        }
        ans.add(new ArrayList(ls));
    }

 private boolean check(boolean[][] row,int i,int j)
    {
        
            for(int b=0;b<row.length;b++)
            {
                if(row[i][b])
                {
                    return false;
                }
            }
            for(int b=0;b<row.length;b++)
            {
                if(row[b][j])
                {
                    return false;
                }
            }
            int x=i,y=j;
            while(x>=0 && y>=0)
            {
                if(row[x][y])
                {
                    return false;
                }
                x--;y--;
            }
            x=i;y=j;
            while(x<row.length && y<row.length)
            {
                if(row[x][y])
                {
                    return false;
                }
                x++;y++;
            } x=i;y=j;
            while(x>=0 && y<row.length)
            {
                if(row[x][y])
                {
                    return false;
                }
                x--;y++;
            } x=i;y=j;
            while(x<row.length && y>=0)
            {
                if(row[x][y])
                {
                    return false;
                }
                x++;y--;
            }
            return true;
        
    }

    private void helper(int n, int i, int j, boolean[][] row) {

        if (n == 0) {
            build(row);
            return;
        }
        if (i >= row.length || j >= row.length) {
            return;
        }
        if (check(row, i, j)) {
            row[i][j] = true;
            if (i == row.length - 1) {
                helper(n - 1, i + 1, 0, row);
            } else {
                for (int a = 0; a < row.length; a++) {
                    //if (check(row, i + 1, a)) {
                        helper(n - 1, i + 1, a, row);
                   // }
                }
            }
            row[i][j] = false;

        }
        return;

    }

    public List<List<String>> solveNQueens(int n) {
        ans.clear();
        for (int i = 0; i < n; i++) {
            boolean[][] row = new boolean[n][n];

            helper(n, 0, i, row);

        }

        return ans;
    }
}