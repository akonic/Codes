class Solution {
    private int maxOfArray(int[] dist) {
        int ans = Integer.MIN_VALUE;
        for (int i : dist) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    private int check(int[] cookies, int i, int[] dist, int l) {
        int n = cookies.length;
        if (i >= cookies.length) {
            return maxOfArray(dist);
        }
        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < l; k++) {
            dist[k] += cookies[i];
            ans = Math.min(ans, check(cookies, i + 1, dist, l));
            if(dist[k]==0)
            {
                break;
            }
            dist[k] -= cookies[i];
        }

        return ans;
    }

    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] dist = new int[k];
        Arrays.fill(dist, 0);
        return check(cookies, 0, dist, k);
    }
}