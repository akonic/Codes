class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            pq.offer(i);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (b - a != 0) {
                pq.offer(Math.abs(a - b));
            }
        }
        if (pq.isEmpty()) {
            return 0;
        } else {
            return pq.peek();
        }
    }
}