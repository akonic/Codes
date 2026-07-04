class Solution {
  //  private dfs( List<List<int[]>> ls,)
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> ls = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ls.add(new ArrayList<>());
        }
        for (int[] i : roads) {
            int x = i[0];
            int y = i[1];
            int cost = i[2];
            ls.get(x).add(new int[] { y, cost });
            ls.get(y).add(new int[] { x, cost });
        }
        int[] costs = new int[n + 1];
        Arrays.fill(costs,Integer.MAX_VALUE);
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[] { 1, Integer.MAX_VALUE });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0];
            int cost = top[1];
            for (int[] i : ls.get(node)) {
                int newNode = i[0];
                int newCost = i[1];
                if (costs[newNode] > Math.min(newCost,cost)) {
                    pq.offer(new int[] { newNode, Math.min(newCost,cost) });
                    costs[newNode] = Math.min(newCost,cost);
                }
            }
        }
        return costs[n];

    }
}