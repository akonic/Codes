class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            pq.offer(new int[] { e.getValue(), e.getKey() });
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.poll()[1];
        }
        return ans;
    }
}