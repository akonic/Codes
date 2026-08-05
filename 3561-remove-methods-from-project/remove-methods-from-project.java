class Solution {
    private void dfs(List<List<Integer>> ls, boolean[] infected, int i) {
        infected[i] = true;
        for (int j : ls.get(i)) {
            if (!infected[j]) {
                dfs(ls, infected, j);
            }
        }

    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>(n);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }
        int m = invocations.length;
        for (int[] i : invocations) {
            ls.get(i[0]).add(i[1]);
        }
        boolean[] infected = new boolean[n];
        dfs(ls, infected, k);
        for (int i = 0; i < n; i++) {
            for (int j : ls.get(i)) {
                if (infected[j] && !infected[i]) {
                    List<Integer> all = new ArrayList<>(n);
                    for (int x = 0; x < n; x++)
                        all.add(x);
                    return all;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!infected[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}