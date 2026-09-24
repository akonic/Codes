class Solution {
    public String pushDominoes(String dominoes) {
        char[] ch = dominoes.toCharArray();
        int n = ch.length;
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == '.') {
                cost[i] = Integer.MAX_VALUE;
            }
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'R') {
                j = 1;
            } else if (ch[i] == 'L') {
                j = 0;
            } else if (ch[i] == '.' && j != 0) {
                ch[i] = 'R';
                cost[i] = j;
                j++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (ch[i] == 'L') {
                j = 1;
            } else if (ch[i] == '.' && j > 0) {
                ch[i] = 'L';
                cost[i] = j;
                j++;
            } else if (ch[i] == 'R') {
                if (cost[i] == j && j > 0) {
                    ch[i] = '.';
                    j = 0;
                } else if (cost[i] > j && j > 0) {

                    ch[i] = 'L';
                    j++;
                } else {

                    j = 0;
                }
            }
        }
        StringBuilder s = new StringBuilder();
        for (char c : ch) {
            s.append(c);
        }
        return s.toString();
    }
}