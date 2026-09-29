class Solution {
    public int maxVowels(String s, int k) {
        int p = 0, ans = 0;

        // for (int i = 0; i < k; i++) {
        //     char c = s.charAt(i);
        //     if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        //         p++;
        //     }
        // }
        // ans = Math.max(ans, p);
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                p++;
            }
            if (i >= k) {
                char d = s.charAt(i - k);
                if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u') {
                    p--;
                }
            }

            ans = Math.max(ans, p);
        }
        return ans;
    }
}