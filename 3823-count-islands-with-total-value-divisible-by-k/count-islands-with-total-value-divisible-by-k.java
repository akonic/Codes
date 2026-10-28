class Solution {
    private long sum(int[][] grid, int i, int j) {
        long c = 0;
        int n = grid.length, m = grid[0].length;
        if (i - 1 >= 0 && grid[i - 1][j] > 0) {
            c += grid[i - 1][j];
            grid[i - 1][j] = -1;
            c += sum(grid, i - 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] > 0) {
            c += grid[i][j - 1];
            grid[i][j - 1] = -1;
            c += sum(grid, i, j - 1);
        }
        if (i + 1 < n && grid[i + 1][j] > 0) {
            c += grid[i + 1][j];
            grid[i + 1][j] = -1;
            c += sum(grid, i + 1, j);
        }
        if (j + 1 < m && grid[i][j + 1] > 0) {
            c += grid[i][j + 1];
            grid[i][j + 1] = -1;
            c += sum(grid, i, j + 1);
        }
        return c;
    }

    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    int val = grid[i][j]; 
                    grid[i][j] = -1;
                    long total = sum(grid, i, j) + val;
                    if (total % k == 0)
                        ans++;
                }
            }
        }
        return ans;
    }
}