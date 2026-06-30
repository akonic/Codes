class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0, b = 0, c = 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        int i = 0, j = 0;
        int ans = 0;
        while (i < n && j < n) {
            if (a == 0 || b == 0 || c == 0) {
                if ( ch[j] == 'a') {
                    a++;
                } else if ( ch[j] == 'b') {
                    b++;
                } else if( ch[j] == 'c'){
                    c++;
                }
                j++;
            }
           while (a != 0 && b != 0 && c != 0) {
                ans += n - j +1;
                if (ch[i] == 'a') {
                    a--;
                } else if (ch[i] == 'b') {
                    b--;
                } else {
                    c--;
                }
                i++;
            }
        }
        return ans;
    }
}