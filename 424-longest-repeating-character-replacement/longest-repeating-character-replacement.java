class Solution {
    private int check(boolean[][] mp, int a, int k) {
        int temp = k;
        int n = mp[a].length;
        int i = 0, j = 0;
        int c = 0, x = 0;
        while (i < n && j < n) {

            if (mp[a][j]) {
                c++;
                j++;
            } else if (!mp[a][j]) {
                if (temp > 0) {
                    temp--;
                    c++;
                    j++;
                } else {
                    if (!mp[a][i]) {
                        temp++;
                    }
                    i++;
                    c--;
                }
            }
            x = Math.max(x, c);

        }

        return x;
    }

    public int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        boolean[] isPresent = new boolean[26];
        boolean[][] mp = new boolean[26][n];
        for (int i = 0; i < n; i++) {
            mp[ch[i] - 'A'][i] = true;
            isPresent[ch[i] - 'A'] = true;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (isPresent[i]) {
                ans = Math.max(ans, check(mp, i, k));
            }
            // System.out.println("----------");
        }
        return ans;
    }
}