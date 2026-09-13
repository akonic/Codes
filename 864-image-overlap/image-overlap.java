class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ls = new ArrayList<>();
        List<int[]> bs = new ArrayList<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    ls.add(new int[] { i, j });
                }
                ;
                if (img2[i][j] == 1) {
                    bs.add(new int[] { i, j });
                }
                ;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] a : ls) {
            for (int[] b : bs) {
                int dx = b[0] - a[0] + 30;
                int dy = b[1] - a[1] + 30;
                int key = dx * 100 + dy;

                int cnt = map.getOrDefault(key, 0) + 1;
                map.put(key, cnt);
                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}