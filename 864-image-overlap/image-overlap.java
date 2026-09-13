class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ls = new ArrayList<>();
        List<int[]> bs = new ArrayList<>();

        Map<String,Integer> mp = new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(img1[i][j]==1){ls.add(new int[]{i,j});};
                if(img2[i][j]==1){bs.add(new int[]{i,j});};
            }
        }
        for (int[] a : ls) {
            for (int[] b : bs) {
                String key = (b[0] - a[0]) + "," + (b[1] - a[1]);
                int cnt = mp.getOrDefault(key, 0) + 1;
                mp.put(key, cnt);
                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}