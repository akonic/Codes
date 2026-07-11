class Solution {
    private void dfs(List<List<Integer>> ls, int i, boolean[] visited, List<Integer> component) {
        visited[i] = true;
        component.add(i);
        for (int j : ls.get(i)) {
            if (!visited[j]) {
                dfs(ls, j, visited, component);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) ls.add(new ArrayList<>());

        for (int[] edge : edges) {
            ls.get(edge[0]).add(edge[1]);
            ls.get(edge[1]).add(edge[0]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(ls, i, visited, component);

                int c = component.size() - 1;
                boolean isComplete = true;
                for (int node : component) {
                    if (ls.get(node).size() != c) {
                        isComplete = false;
                        break;
                    }
                }
                if (isComplete) ans++;
            }
        }
        return ans;
    }
}