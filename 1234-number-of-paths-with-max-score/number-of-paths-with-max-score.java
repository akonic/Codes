class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = 1_000_000_007;
        char[][] charBoard = board.stream()
                .map(String::toCharArray)
                .toArray(char[][]::new);
        int n = charBoard.length;

        long[][] bestCost = new long[n][n];
        long[][] bestCount = new long[n][n];
        for (long[] row : bestCost)
            Arrays.fill(row, -1);

        bestCost[n - 1][n - 1] = 0;
        bestCount[n - 1][n - 1] = 1;

        for (int x = n - 1; x >= 0; x--) {
            for (int y = n - 1; y >= 0; y--) {
                if (charBoard[x][y] == 'X' || bestCost[x][y] < 0)
                    continue;

                int[][] dirs = { { -1, 0 }, { 0, -1 }, { -1, -1 } };
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || ny < 0 || charBoard[nx][ny] == 'X')
                        continue;

                    int cellVal = (nx == 0 && ny == 0) ? 0 : charBoard[nx][ny] - '0';
                    long newCost = bestCost[x][y] + cellVal;

                    if (newCost > bestCost[nx][ny]) {
                        bestCost[nx][ny] = newCost;
                        bestCount[nx][ny] = bestCount[x][y];
                    } else if (newCost == bestCost[nx][ny]) {
                        bestCount[nx][ny] = (bestCount[nx][ny] + bestCount[x][y]) % MOD;
                    }
                }
            }
        }

        if (bestCost[0][0] < 0)
            return new int[] { 0, 0 };
        return new int[] { (int) bestCost[0][0], (int) bestCount[0][0] };
    }
}