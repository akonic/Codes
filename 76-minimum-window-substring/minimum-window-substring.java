class Solution {
    private boolean check(int[] a1, int[] a2) {
        for (int i = 0; i < 128; i++) {
            if (a1[i] < a2[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        String ans = "";
        int n = s.length();
        int m = t.length();

        if (m > n) {
            return ans;
        }

        int len = Integer.MAX_VALUE;
        int ind = -1;

        // int i = 0, j = 0;

        char[] ch = s.toCharArray();

        int[] freq1 = new int[128];
        int[] freq2 = new int[128];
        for (int k = 0; k < m; k++) {
            freq2[t.charAt(k)]++;
        }
        freq1[ch[0]]++;

        int i = 0, j = 0;

        while (i < n && j < n) {

            while (i < n && check(freq1, freq2)) {
                if (j - i + 1 < len) {
                    len = j - i + 1;
                    ind = i;
                }

                freq1[ch[i]]--;
                i++;
            }

            j++;
            if (j < n) {
                freq1[ch[j]]++;
            }
        }
        if (ind == -1) {
            return ans;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(ind, ind + len);
    }
}