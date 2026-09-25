class Solution {
    public String answerString(String word, int k) {
        char[] ch = word.toCharArray();
        int n = ch.length;
        char c = 'a';
        for (int i = 0; i < n; i++) {
            if (ch[i] > c) {
                c = ch[i];
            }
        }
        if(k==1)
        {
            return word;
        }
        int maxLen = n - k + 1;
        String ans = "a";
        for (int i = 0; i < n; i++) {
            if (ch[i] == c) {
                StringBuilder s = new StringBuilder();
                int p = Math.max(i - 1, 0);
                int j = i;
                int bound = Math.min(n, i + maxLen);

                while (j < bound) {
                    s.append(ch[j]);
                    j++;
                }

                if (s.toString().compareTo(ans) > 0) {
                    ans = s.toString();
                }
            }
        }
        return ans;
    }
}