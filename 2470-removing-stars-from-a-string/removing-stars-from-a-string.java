class Solution {
    public String removeStars(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;

        Stack<Character> st = new Stack<>();
        for(char c : ch)
        {
            if(c=='*')
            {
                st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }
        return ans.reverse().toString(); 
    }
}