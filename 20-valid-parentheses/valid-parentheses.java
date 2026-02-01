class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.size() != 0) {
                    if ((c == ')' && st.peek() != '(') ||
                            (c == '}' && st.peek() != '{') || (c == ']' && st.peek() != '[')) {
                        return false;
                    } else {
                        st.pop();
                    }
                }
                else{
                    return false;
                }
            }
            i++;
        }
        if (st.size() > 0) {
            return false;
        }
        return true;
    }
}