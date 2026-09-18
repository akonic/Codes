class Solution {
    public String reverseWords(String s) {
        int n= s.length();
        StringBuilder st = new StringBuilder();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                if (st.length() > 0) {
                    ls.add(st.toString());
                    st = new StringBuilder();
                }
            } else {
                st.append(s.charAt(i));
            }
        }
        if (st.length() > 0) {
            ls.add(st.toString());
        }
        Collections.reverse(ls);
        st = new StringBuilder();
        int sz=ls.size();
        for(int i=0;i<sz;i++)
        {
            st.append(ls.get(i));
            if(i!=sz-1)
            {
                st.append(" ");
            }
        }
        return st.toString();

    }
}