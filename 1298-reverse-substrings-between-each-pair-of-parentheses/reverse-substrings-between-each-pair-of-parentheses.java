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
        // return helper(s,0);
        int n = s.length();
        char[] ch = s.toCharArray();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == '(' || ch[i] == ')') {
                count++;
            }
        }
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder(s);
        while (count > 0) {
            int u=temp.length();
            String t = temp.toString();
            int p = count / 2;
            int i = 0;
            while (p > 0) {
                if (t.charAt(i) == '(') {
                    p--;
                }
                i++;
            }
            int q = i-1;
            StringBuilder temp1 = new StringBuilder();
            while (t.charAt(i) != ')') {
                temp1.append(t.charAt(i));
                i++;
            }
           /// System.out.println(temp1);
            StringBuilder temp3 = new StringBuilder();
            int h = 0;
            while (h < u) {
                if (h == q) {
                    temp3.append(temp1.reverse().toString());
                    h = i + 1;
                } else {
                    temp3.append(temp.charAt(h));
                    h++;
                }
            }
            temp.setLength(0);

            temp.append(temp3);
            count -= 2;

        }
        return temp.toString();

    }
}