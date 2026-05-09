class Solution {
    void rotate(int[][] grid, int p, int n, int m) {
        int i = p;
        int j = p;
        int x = grid[i][j];
        i++;
        while (i < n - p) {

            int f = grid[i][j];
            grid[i][j] = x;
            x = f;
            i++;
        }
        i = n - p - 1;
        j++;
        while (j < m - p) {

            int f = grid[i][j];
            grid[i][j] = x;
            x = f;

            j++;
        }
        j = m - p - 1;
        i--;
        while (i >= p) {

            int f = grid[i][j];
            grid[i][j] = x;
            x = f;

            i--;
        }
        i = p;
        j--;
        while (j >= p) {

            int f = grid[i][j];
            grid[i][j] = x;
            x = f;

            j--;
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < Math.min(n, m) / 2; i++)  {
            int x = n - 2 * i;
            int y = m - 2 * i;
            int z = 2 * (x + y - 2);
            int effective = k % z;
            for (int o = 0; o < effective; o++) {
                rotate(grid, i, n, m);
            }
        }

        return grid;
    }
}