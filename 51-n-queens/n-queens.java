class Solution {
    Set<List<String>> ans = new HashSet<>();

    private void build(boolean[][] row) {

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                if (row[i][j]) {
                    s.append('Q');
                } else {
                    s.append('.');
                }
            }
            ls.add(s.toString());
        }
        ans.add(new ArrayList(ls));
    }

    private boolean check(boolean[][] board, int i, int j) {

        for (int r = 0; r < i; r++) {
            if (board[r][j])
                return false;
        }

        for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c])
                return false;
        }

        for (int r = i - 1, c = j + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c])
                return false;
        }

        return true;
    }

    private void helper(int n, int i, int j, boolean[][] row) {

        if (n == 0) {
            build(row);
            return;
        }
        if (i >= row.length || j >= row.length) {
            return;
        }
        if (check(row, i, j)) {
            row[i][j] = true;
            if (i == row.length - 1) {
                helper(n - 1, i + 1, 0, row);
            } else {
                for (int a = 0; a < row.length; a++) {
                    if (check(row, i + 1, a)) {
                        helper(n - 1, i + 1, a, row);
                    }
                }
            }
            row[i][j] = false;

        }
        return;

    }

    public List<List<String>> solveNQueens(int n) {
        ans.clear();
        for (int i = 0; i < n; i++) {
            boolean[][] row = new boolean[n][n];

            helper(n, 0, i, row);

        }
        List<List<String>> p = new ArrayList<>();
        for (List<String> u : ans) {
            p.add(new ArrayList<>(u));
        }

        return p;
    }
}