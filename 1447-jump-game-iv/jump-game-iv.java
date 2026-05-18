class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = arr.length;
      
        for (int i = 0; i < n; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<Integer>());
            mp.get(arr[i]).add(i);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{ n-1, 0 });
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[n-1] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0];
            int jumps = top[1];
            if (jumps > cost[node]) continue;

            if (node + 1 < n && cost[node + 1] > jumps + 1) {
                cost[node + 1] = jumps + 1;
                pq.offer(new int[] { node + 1, jumps + 1 });
            }
            if (node - 1 >= 0 && cost[node - 1] > jumps + 1) {
                cost[node - 1] = jumps + 1;
                pq.offer(new int[] { node - 1, jumps + 1 });
            }
            List<Integer> bucket = mp.get(arr[node]);
            if (bucket != null) {
                for (int i : bucket) {
                    if (cost[i] > jumps + 1) {
                        cost[i] = jumps + 1;
                        pq.offer(new int[] { i, jumps + 1 });
                    }
                }
                bucket.clear();
            }
        }
        return cost[0];
    }
}