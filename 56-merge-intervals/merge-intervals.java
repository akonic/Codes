class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n=intervals.length;
        List<int[]> ls = new ArrayList<>();
        int x=intervals[0][0];
        int y=intervals[0][1];
        for(int i=1;i<n;i++)
        {
            int a = intervals[i][0];
            int b = intervals[i][1];
            if(y>=a && y>=b)
            {

            }
            else if(y>=a && y<b)
            {
                y=b;
            }
            else if(y<a)
            {
                ls.add(new int[]{x,y});
                x=a;y=b;
            }
        }
        ls.add(new int[]{x,y});
        int p = ls.size();
        int[][] ans = new int[p][2];
        for(int i=0;i<p;i++)
        {
            ans[i][0]=ls.get(i)[0];
            ans[i][1]=ls.get(i)[1];
        }
        return ans;
    }
}