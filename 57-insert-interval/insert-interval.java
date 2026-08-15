class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ls = new ArrayList<>();
        List<int[]> as = new ArrayList<>();
        for(int[] i : intervals)
        {
            ls.add(i);
        }
        ls.add(newInterval);
        Collections.sort(ls,(a,b)->(a[0]-b[0]));
        int m =ls.size();
        int[][] check = new int[m][2];
        for(int i=0;i<m;i++)
        {
            check[i]=ls.get(i);
        }
        int x=check[0][0];
        int y=check[0][1];
        for(int i=1;i<m;i++)
        {
            if(y<check[i][0])
            {
                as.add(new int[]{x,y});
                x=check[i][0];
                y=check[i][1];
            }
            else{
                y=Math.max(y,check[i][1]);
            }
        }
        as.add(new int[]{x,y});
        int u= as.size();
        int[][] ans = new int[u][2];
        for (int i = 0; i < u; i++) {
            ans[i][0] = as.get(i)[0];
            ans[i][1] = as.get(i)[1];
        }
        return ans;
    }
}