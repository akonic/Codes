class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            int c = roads[i][2];
            adj.get(a).add(new int[] { b, c });
            adj.get(b).add(new int[] { a, c });
        }
        long[] cost = new long[n];
        long[] ways = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])); 
        pq.offer(new long[] { 0, 0 });
        cost[0] = 0;
        while (!pq.isEmpty()) {
            long[] arr = pq.poll();
            long dist = arr[0];
            int node = (int) arr[1];

            if (dist > cost[node])
                continue;

            for (int[] i : adj.get(node)) {
                int newNode = i[0];
                int newDist = i[1];
                if (cost[node] + newDist < cost[newNode]) {
                    cost[newNode] = cost[node] + newDist;
                    ways[newNode] = ways[node];
                    pq.offer(new long[] { cost[newNode], newNode });
                } else if (cost[node] + newDist == cost[newNode]) {
                    ways[newNode] = (ways[newNode] + ways[node]) % mod;
                }
            }
        }
        return (int) ways[n - 1];
    }
}