class Solution {
    private boolean check1(int[][] heights, boolean[][] vis1, int i, int j, int n, int m) {
        if (i + 1 == n || j + 1 == m)
            return true;
        vis1[i][j] = true;
        boolean a = false, b = false, c = false, d = false;
        if (!vis1[i + 1][j] && heights[i][j] >= heights[i + 1][j])
            a = check1(heights, vis1, i + 1, j, n, m);
        if (!vis1[i][j + 1] && heights[i][j] >= heights[i][j + 1])
            b = check1(heights, vis1, i, j + 1, n, m);
        if (j > 0 && !vis1[i][j - 1] && heights[i][j] >= heights[i][j - 1])
            c = check1(heights, vis1, i, j - 1, n, m);
        if (i > 0 && !vis1[i - 1][j] && heights[i][j] >= heights[i - 1][j])
            d = check1(heights, vis1, i - 1, j, n, m);
        return a || b || c || d;
    }

    private boolean check2(int[][] heights, boolean[][] vis2, int i, int j, int n, int m) {
        if (i == 0 || j == 0)
            return true; 
        vis2[i][j] = true;
        boolean a = false, b = false, c = false, d = false;
        if (!vis2[i - 1][j] && heights[i][j] >= heights[i - 1][j])
            a = check2(heights, vis2, i - 1, j, n, m);
        if (!vis2[i][j - 1] && heights[i][j] >= heights[i][j - 1])
            b = check2(heights, vis2, i, j - 1, n, m);
        if (i + 1 < n && !vis2[i + 1][j] && heights[i][j] >= heights[i + 1][j])
            c = check2(heights, vis2, i + 1, j, n, m);
        if (j + 1 < m && !vis2[i][j + 1] && heights[i][j] >= heights[i][j + 1])
            d = check2(heights, vis2, i, j + 1, n, m);
        return a || b || c || d;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] vis1 = new boolean[n][m];
                boolean[][] vis2 = new boolean[n][m];
                if (check1(heights, vis1, i, j, n, m) && check2(heights, vis2, i, j, n, m)) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;

    }
}