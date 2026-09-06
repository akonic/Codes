class Solution {
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (st.size() > 0) {
                if (Character.toLowerCase(st.peek()) == Character.toLowerCase(c)
                        && st.peek() != c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else {
                st.push(c);
            }
        }
        while (st.size() > 0) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}