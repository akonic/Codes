class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        int ans=n;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int x=intervals[0][0];
        int y=intervals[0][1];
        for(int i=1;i<n;i++)
        {
           // System.out.println(x + " "+ y);
            int a=intervals[i][0];
            int b=intervals[i][1];
            if(y>=a && y>=b)
            {
                ans--;
            }
            else if(y>=a && y<=b)
            {
                if(x==a)
                {
                    ans--;
                    x=a;
                    y=b;
                }
                else{
                    x=a;y=b;
                }
            }
            else{
                x=a;
                y=b;
            }
        }
        return ans;
    }
}