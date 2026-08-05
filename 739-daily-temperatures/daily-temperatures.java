class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for(int i=1;i<n;i++)
        {
            int element=nums[i];
            while(!st.isEmpty() && element>nums[st.peek()])
            {
                int top=st.pop();
                ans[top]=i-top;
            }
            st.push(i);
        }
        return ans;
    }
}