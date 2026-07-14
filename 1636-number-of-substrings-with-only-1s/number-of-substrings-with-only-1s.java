class Solution {
    public int numSub(String s) {
        List<Integer> ls = new ArrayList<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == '1') {
                c++;
            } else {
                if (c > 0) {
                    ls.add(c);
                    c = 0;
                }
            }
        }
        if (c > 0) {
            ls.add(c);
            c = 0;
        }
        int mod = 1000000007;
        int ans = 0;
        for (int i : ls) {
            long term1 = i % mod;
            long term2 = (i + 1) % mod;
            long product = (term1 * term2) % mod;

            ans = (int)(ans + (product * ((mod + 1) / 2)) % mod) % mod;
        }
        return ans;
    }
}