class Solution {
    private int check(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;
        int n = grid.length;
        int m = grid[0].length;
        q.offer(new int[] { i, j });
        grid[i][j] = -1;
        if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
            flag = true;
        }
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                grid[x - 1][y] = -1;
                q.offer(new int[] { x - 1, y });
                if (x - 1 == 0 || y == 0 || x - 1 == n - 1 || y == m - 1) {
                    flag = true;
                }
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                grid[x][y - 1] = -1;
                q.offer(new int[] { x, y - 1 });
                if (x == 0 || y - 1 == 0 || x == n - 1 || y - 1 == m - 1) {
                    flag = true;
                }
            }
            if (x + 1 < n && grid[x + 1][y] == 0) {
                grid[x + 1][y] = -1;
                q.offer(new int[] { x + 1, y });
                if (x + 1 == 0 || y == 0 || x + 1 == n - 1 || y == m - 1) {
                    flag = true;
                }
            }
            if (y + 1 < m && grid[x][y + 1] == 0) {
                grid[x][y + 1] = -1;
                q.offer(new int[] { x, y + 1 });
                if (x == 0 || y + 1 == 0 || x == n - 1 || y + 1 == m - 1) {
                    flag = true;
                }
            }
        }
        if (flag) {
            return 0;
        }
        return 1;
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    ans += check(grid, i, j);
                }
            }
        }
        return ans;
    }
}