class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] depth = new int[n][m];
       
        int ans = 0;
       
        for (int j = 0; j < m; j++) {
            int c = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (matrix[i][j] == '1') {
                    c++;
                } else {
                    c = 0;
                }
                depth[i][j] = c;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    int x = depth[i][j];
                    int width = 0;
                    int k = j;
                    while (k < m && matrix[i][k] == '1') {
                        x = Math.min(x, depth[i][k]);
                        width++;
                        ans = Math.max(ans, x * width);
                        k++;
                    }
                }
            }
        }

        return ans;
    }
}