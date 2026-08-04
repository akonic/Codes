class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        Stack<int[]> st = new Stack<>();
        Set<Integer> ls = new HashSet<>();
        int i = 0;
        while (i < n) {
            if (ch[i] == '(') {
                st.push(new int[] { 1, i });
            } else if (ch[i] == ')') {
                if (!st.isEmpty()) {
                    int[] top = st.peek();
                    if (top[0] == 1) {
                        st.pop();
                    } else {
                        ls.add(i);
                    }
                }
                else{
                    ls.add(i);
                }
            }
            i++;
        }
        while (!st.isEmpty()) {
            ls.add(st.peek()[1]);
            st.pop();
        }
        String ans = "";
        i = 0;
        while (i < n) {
            if (ch[i] == '(' || ch[i] == ')') {
                if (!ls.contains(i)) {
                    ans += ch[i];
                }
            } else {
                ans += ch[i];
            }
            i++;
        }
        return ans;
    }
}