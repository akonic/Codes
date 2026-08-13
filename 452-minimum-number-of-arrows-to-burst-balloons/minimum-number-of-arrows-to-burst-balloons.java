class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0], b[0]));
        int n = points.length;
        int j=0;
        int ans=1;

        for (int i = 1; i < n; i++) {

            if (points[i][0] <= points[j][1]) {

                points[j][1] = Math.min(points[j][1], points[i][1]);

            } else {

                ans++;
                j = i;
            }
        }
        return ans;
    }
}