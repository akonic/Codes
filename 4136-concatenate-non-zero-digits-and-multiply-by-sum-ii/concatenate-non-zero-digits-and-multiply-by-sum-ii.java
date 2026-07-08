class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        String ns = "";
        int n = s.length();
        int[] zero = new int[n];
        int MOD = 1000000007;
        List<Integer> ls = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c - '0' != 0) {
                ns += c;
                ls.add(c - '0');
            } else {
                x++;
            }
            zero[i] = x;
        }
        //System.out.println("Ns : "+ns);
        int p = ls.size();
        int[] pre = new int[p];
        int sum = 0;
        for (int i = 0; i < p; i++) {
            sum += ls.get(i);
            pre[i] = sum;
            // System.out.println(i+" "+pre[i]);
        }
        long[] pw = new long[p + 1];
        long[] modPrefix = new long[p + 1];
        pw[0] = 1;
        for (int i = 0; i < p; i++) {
            pw[i + 1] = (pw[i] * 10) % MOD;
            modPrefix[i + 1] = (modPrefix[i] * 10 + (ns.charAt(i) - '0')) % MOD;
        }
        //System.out.println("--------------------");
        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == r) {
                int c = s.charAt(l) - '0';
                ans[i] = c * c;
            } else {
                int newl = l, newr = r;
                //System.out.println(l + " "+r+" "+zero[r]);
                if (l != 0) {
                    newl -= zero[l - 1];
                }
                if (r != 0) {
                    newr -= zero[r];
                }
                // System.out.println(newl + " "+newr);

                if (newl > newr) {
                    ans[i] = 0;
                } else {
                    int rlen = newr - newl + 1;
                    // non = ns[newl..newr] as number mod MOD, O(1) via prefix mods
                    long non = ((modPrefix[newr + 1] - modPrefix[newl] * pw[rlen]) % MOD + MOD) % MOD;
                    int su;
                    if (newl == 0) {
                        su = pre[newr];
                    } else {
                        su = pre[newr] - pre[Math.max(newl - 1, 0)];
                    }
                    //System.out.println("Su"+su);
                    ans[i] = (int) (((long) su * non) % 1000000007);
                }
            }

        }
        return ans;

    }
}