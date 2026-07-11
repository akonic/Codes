class Solution {
    private int[][] right, down;

    private boolean check(int[][] grid, int i, int j, int k) {
        int len = k + 1;
        // top edge: run of 1's starting at (i,j) going right
        if (right[i][j] < len) return false;
        // bottom edge: run of 1's starting at (i+k,j) going right
        if (right[i + k][j] < len) return false;
        // left edge: run of 1's starting at (i,j) going down
        if (down[i][j] < len) return false;
        // right edge: run of 1's starting at (i,j+k) going down
        if (down[i][j + k] < len) return false;
        return true;
    }

    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        right = new int[n][m];
        down = new int[n][m];

        // Build prefix run-lengths from bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = 1 + (j + 1 < m ? right[i][j + 1] : 0);
                    down[i][j]  = 1 + (i + 1 < n ? down[i + 1][j] : 0);
                }
                // else stays 0 (default)
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < Math.min(n - i, m - j); k++) {
                        if (check(grid, i, j, k)) {
                            ans = Math.max(ans, (k + 1) * (k + 1));
                        }
                    }
                }
            }
        }
        return ans;
    }
}