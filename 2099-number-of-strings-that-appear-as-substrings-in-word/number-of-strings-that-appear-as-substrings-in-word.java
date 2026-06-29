class Solution {

    private boolean check(char[] a, char[] b) {
        int n = a.length, m = b.length;
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && a[i + j] == b[j])
                j++;
            if (j == m)
                return true;
        }
        return false;
    }

    public int numOfStrings(String[] patterns, String word) {
        char[] ch = word.toCharArray();
        int ans = 0;
        for (int i = 0; i < patterns.length; i++) {
            char[] ch2 = patterns[i].toCharArray();
            if (check(ch, ch2)) {
                ans++;
            }
        }
        return ans;
    }
}