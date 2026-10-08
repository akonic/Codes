class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int i = 0;
        boolean[] check = new boolean[n];
        Arrays.fill(check, true);
        while (i < n) {
            int c = 1;
            int j = i + 1;
            while (j < n && c > 0) {
                if (s.charAt(j) == '(') {
                    c++;
                } else {
                    c--;
                }
                j++;
            }
            
                check[i] = false;
                j--;
                check[j] = false;
                
            
            i = j + 1;
        }

        StringBuilder ans = new StringBuilder();
        for (i = 0; i < n; i++) {
            if (check[i]) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();

    }
}