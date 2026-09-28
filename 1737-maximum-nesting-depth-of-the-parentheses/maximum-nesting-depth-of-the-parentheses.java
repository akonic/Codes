class Solution {
    public int maxDepth(String s) {
        int ans=0;
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push('(');
            }
            else if(s.charAt(i)==')')
            {
                ans=Math.max(ans,st.size());
                st.pop();
            }
        }
        return ans;
    }
}