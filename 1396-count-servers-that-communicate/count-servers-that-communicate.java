class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] row = new int[n][m];
        int[][] col = new int[n][m];

        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                c += grid[i][j];
                row[i][j] = c;
            }
        }
        for (int i = 0; i < m; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                c += grid[j][i];
                col[j][i] = c;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (row[i][m - 1] >= 2 || col[n - 1][j] >= 2)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}