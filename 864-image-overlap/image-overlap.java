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
        for(int[] i : ls)
        {
            for(int[] j : bs)
            {
                String key = (i[0]-j[0])+"_"+(i[1]-j[1]);
                mp.put(key,mp.getOrDefault(key,0)+1);
                ans=Math.max(ans,mp.get(key));
            }
        }
        return ans;
    }
}