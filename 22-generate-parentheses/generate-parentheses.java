class Solution {
    private boolean check(char[] ch,int n)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(ch[i]=='(')
            {
                st.push(ch[i]);
            }
            else{
                if(st.size()==0)
                {
                    return false;
                }
                if(st.peek()!='(')
                {
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        if(st.size()!=0)
        {
            return false;
        }
        return true;
    }
    private void helper(List<String> ls,char[] ch,int n,int i)
    {
        if(i==n)
        {
            if(check(ch,n))
            {
                ls.add(String.valueOf(ch));
            }
            return;
        }

        ch[i]='(';
        helper(ls,ch,n,i+1);
        ch[i]=')';
        helper(ls,ch,n,i+1);
    }
    public List<String> generateParenthesis(int n) {
        char[] ch = new char[2*n];

        List<String> ls = new ArrayList<>();
        helper(ls,ch,2*n,0);

        return ls;
    }
}