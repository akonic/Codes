class Solution {
    private boolean check(int[][] grid, int i, int j, int k) {
       // System.out.println(i+" "+j+ " "+k);
        for (int l = i; l <=i+k; l++) {
            if (grid[l][j] != 1 || grid[l][j + k] != 1) {
                return false;
            }
        }
        for (int l = j; l <=j+k; l++) {
            if (grid[i][l] != 1 || grid[i + k][l] != 1) {
                return false;
            }
        }
        return true;
    }

    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < Math.min(n-i,m-j); k++) {
                        if (check(grid, i, j, k)) {
                            ans = Math.max(ans, (k + 1) * (k + 1));
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return ans;

    }
}