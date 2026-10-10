class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] { i, j });
                    grid[i][j] = '0'; 
                    while (!q.isEmpty()) {
                        int[] top = q.poll();
                        int x = top[0];
                        int y = top[1];
                        if (x + 1 < n && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            q.offer(new int[] { x + 1, y });
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            q.offer(new int[] { x - 1, y });
                        }
                        if (y + 1 < m && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            q.offer(new int[] { x, y + 1 });
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            q.offer(new int[] { x, y - 1 });
                        }
                    }

                }
            }
        }

        return ans;
    }
}