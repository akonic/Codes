class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++)
        {
            while(!st.isEmpty() && nums[i]>nums[st.peek()])
            {
                int top=st.pop();
                ans[top]=i-top;
            }
            st.push(i);
        }
        return ans;
    }
}