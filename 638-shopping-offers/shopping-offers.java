class Solution {
    private boolean check(int[] need) {
        for (int i = 0; i < need.length; i++) {
            if (need[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean check2(int[] need) {
        for (int i = 0; i < need.length; i++) {
            if (need[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean check3(int[] need, int[] cc) {
        for (int i = 0; i < need.length; i++) {
            if (need[i] - cc[i] < 0) {
                return false;
            }
        }
        return true;
    }

    private int helper(int[] prices, int[] need, int[][] offer, Map<String, Integer> mp) {
        if (check(need))
            return 0;

        String key = Arrays.toString(need);

        if (mp.containsKey(key)) {
            return mp.get(key);
        }
        int ans = 0;
        for (int i = 0; i < need.length; i++) {
            ans += need[i] * prices[i];
        }
        for (int i = 0; i < offer.length; i++) {
            if (check3(need, offer[i])) {
                for (int j = 0; j < need.length; j++) {
                    need[j] -= offer[i][j];
                }
                ans = Math.min(ans, offer[i][need.length] + helper(prices, need, offer, mp));
                for (int j = 0; j < need.length; j++) {
                    need[j] += offer[i][j];
                }
            }
        }
        mp.put(key, ans);
        return ans;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        int[] prices = new int[n];
        int[] need = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = price.get(i);
            need[i] = needs.get(i);
        }
        int m = special.size();
        int[][] offer = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 1; j++) {
                offer[i][j] = special.get(i).get(j);
            }
        }
        Map<String, Integer> mp = new HashMap<>();
        return helper(prices, need, offer, mp);
    }
}