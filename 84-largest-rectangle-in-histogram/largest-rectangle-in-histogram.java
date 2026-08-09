class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> st = new Stack<>();
        int ans=0;  
        for(int i=0;i<n;i++)
        {
            int ind=i;
            while(!st.isEmpty() && st.peek()[1]>heights[i])
            {
                int[] x = st.pop();
                ind=Math.min(ind,x[0]);
                ans=Math.max(ans,x[1]*(i-x[0]));
                ans=Math.max(ans,x[1]);
            }
            st.push(new int[]{ind,heights[i]});
        }
        while(!st.isEmpty())
        {
            int[] x=st.pop();
            ans=Math.max(ans,x[1]*(n-x[0]));
        }
        return ans;
    }
}