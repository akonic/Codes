class Solution {
    // private String helper(String s,int i)
    // {
    //     if(i>=s.length())
    //     {
    //         return "";
    //     }
    //     StringBuilder ans = new StringBuilder();
    //     if(s.charAt(i)=='(')
    //     {
    //         i++;
    //         while(s.charAt(i)!=')')
    //         {
    //             ans.append()
    //         }
    //     }
    //     else{
    //         ans.append(ch[i]);
    //     }
    //    return ans.reverse().toString();
    // }
    public String reverseParentheses(String s) {
        StringBuilder temp = new StringBuilder(s);

        while (true) {
            int left = temp.lastIndexOf("(");
            if (left == -1)
                break;

            int right = temp.indexOf(")", left);

            StringBuilder rev = new StringBuilder(temp.substring(left + 1, right));
            rev.reverse();

            temp.replace(left, right + 1, rev.toString());
        }

        return temp.toString();
    }
}