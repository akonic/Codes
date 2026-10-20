class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());
        }
        for (int[] i : flights) {
            ls.get(i[0]).add(new int[] { i[1], i[2] });
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int steps = 0;
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        while (!q.isEmpty() && steps <= k) {
            steps++;
            int sz = q.size();
            while (sz > 0) {
                sz--;
                int[] top = q.poll();
                int node = top[0];
                int cst = top[1];
                for (int[] i : ls.get(node)) {
                    if (cst + i[1] < cost[i[0]]) {
                        cost[i[0]] = cst + i[1];
                        q.offer(new int[] { i[0], cst + i[1] });
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}