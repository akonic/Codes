class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int sr = flights[i][0];
            int dt = flights[i][1];
            int cost = flights[i][2];
            adj.get(sr).add(new int[] { dt, cost });
        }
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE); 

        pq.offer(new int[] { 0, src, 0 });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int cost = top[0];
            int node = top[1];
            int stops = top[2];

            if (node == dst)
                return cost;
            if (stops == k + 1)
                continue;

            if (stops >= minStops[node])
                continue; 
            minStops[node] = stops; 

            for (int[] temp : adj.get(node)) {
                pq.offer(new int[] { cost + temp[1], temp[0], stops + 1 });
            }
        }
        return -1;
    }
}