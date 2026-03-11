class Solution {

    boolean helper(char[][] board, String word, int i, int j, int len, int c, int n, int m, int[][] visited) {

        if (c == len) {
            return true;
        }

        if (i + 1 < n && visited[i + 1][j] == 0 && board[i + 1][j] == word.charAt(c)) {
            visited[i + 1][j] = 1;
            if (helper(board, word, i + 1, j, len, c + 1, n, m, visited))
                return true;
            visited[i + 1][j] = 0;
        }

        if (j + 1 < m && visited[i][j + 1] == 0 && board[i][j + 1] == word.charAt(c)) {
            visited[i][j + 1] = 1;
            if (helper(board, word, i, j + 1, len, c + 1, n, m, visited))
                return true;
            visited[i][j + 1] = 0;
        }

        if (i - 1 >= 0 && visited[i - 1][j] == 0 && board[i - 1][j] == word.charAt(c)) {
            visited[i - 1][j] = 1;
            if (helper(board, word, i - 1, j, len, c + 1, n, m, visited))
                return true;
            visited[i - 1][j] = 0;
        }

        if (j - 1 >= 0 && visited[i][j - 1] == 0 && board[i][j - 1] == word.charAt(c)) {
            visited[i][j - 1] = 1;
            if (helper(board, word, i, j - 1, len, c + 1, n, m, visited))
                return true;
            visited[i][j - 1] = 0;
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;
        int len = word.length();

        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == word.charAt(0)) {

                    visited[i][j] = 1;

                    if (helper(board, word, i, j, len, 1, n, m, visited))
                        return true;

                    visited[i][j] = 0;
                }
            }
        }

        return false;
    }
}