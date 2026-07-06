class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int[][] ans = new int[n][2];
        int idx = 0;
        int x = intervals[0][0];
        int y = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if (y >= a && y >= b) {

            } else if (y >= a && y < b) {
                y = b;
            } else if (y < a) {
                ans[idx][0] = x;
                ans[idx][1] = y;
                idx++;
                x = a;
                y = b;
            }
        }
        ans[idx][0] = x;
        ans[idx][1] = y;
        idx++;

        return Arrays.copyOf(ans, idx);
    }
}