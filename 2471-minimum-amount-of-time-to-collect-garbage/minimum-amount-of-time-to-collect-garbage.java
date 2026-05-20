class Solution {
    private int helper(int[] arr, int n, int[] travel) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            
            if (i == 0) {
                if (arr[i] != 0) {
                    ans += arr[i];
                }
            } else {
                ans += travel[i - 1];
                if (arr[i] > arr[i - 1]) {
                    ans += arr[i] - arr[i - 1];
                }
            }
            if (arr[i] == arr[n - 1]) {
                return ans;
            }
        }
        return ans;
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int n = garbage.length;
        int[] m = new int[n];
        int[] p = new int[n];
        int[] g = new int[n];
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            char[] waste = garbage[i].toCharArray();
            for (char d : waste) {
                if (d == 'M') {
                    a++;
                } else if (d == 'P') {
                    b++;
                } else {
                    c++;
                }
            }
            m[i] = a;
            p[i] = b;
            g[i] = c;
        }
        ans += helper(m, n, travel);
        ans += helper(g, n, travel);
        ans += helper(p, n, travel);
        return ans;
    }
}