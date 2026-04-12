class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(ans[i], -1);

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    ans[i][j] = 0;
                    q.offer(i * m + j);
                }

        if (q.isEmpty() || q.size() == n * m)
            return -1;

        int result = -1;
        while (!q.isEmpty()) {
            int top = q.poll();
            int x = top / m, y = top % m;
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && ans[nx][ny] == -1) {
                    ans[nx][ny] = ans[x][y] + 1;
                    result = Math.max(result, ans[nx][ny]);
                    q.offer(nx * m + ny);
                }
            }
        }
        return result;
    }
}