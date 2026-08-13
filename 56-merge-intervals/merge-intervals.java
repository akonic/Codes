class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ls = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int x=intervals[0][0];
        int y=intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if(y<intervals[i][0])
            {
                ls.add(new int[]{x,y});
                x=intervals[i][0];
                y=intervals[i][1];
            }
            else{
                y=Math.max(y,intervals[i][1]);
            }
        }
        ls.add(new int[]{x,y});

        int m = ls.size();
        int[][] ans = new int[m][2];
        for(int i=0;i<m;i++)
        {
            ans[i][0]=ls.get(i)[0];
            ans[i][1]=ls.get(i)[1];
        }
        return ans;
    }
}