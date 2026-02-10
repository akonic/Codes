class Pair {
    int first;
    int second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

class Solution {
    public int fun(int m, int n, int i, List<Pair> list,int[][][] dp) {
        if (m < 0 || n < 0)
            return Integer.MIN_VALUE;
        if (i >= list.size())
            return 0;
        if(dp[i][m][n]!=-1)
        {
            return dp[i][m][n];
        }
        int a = 0, b = 0;
        int x = list.get(i).first, y = list.get(i).second;
        if (m - x >= 0 && n - y >= 0) {
            a = 1 + fun(m - x, n - y, i + 1, list,dp);
        }
        b = fun(m, n, i + 1, list,dp);
        return dp[i][m][n]=Math.max(a, b);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        List<Pair> list = new ArrayList<>();
        int x = strs.length;
        for (int i = 0; i < x; i++) {
            int a = 0, b = 0;
            String st = strs[i];
            int p = st.length();
            for (int j = 0; j < p; j++) {
                if (st.charAt(j) == '0') {
                    a++;
                } else {
                    b++;
                }
            }
            list.add(new Pair(a, b));
        }
        int ans = 0;
        int[][][] dp = new int [list.size()+1][m+1][n+1];
        for(int[][] rows : dp)
        {
            for(int[] cols : rows)
            {
                Arrays.fill(cols,-1);
            }
        }
        int p = fun(m, n, 0, list,dp);
        return p;

    }
}