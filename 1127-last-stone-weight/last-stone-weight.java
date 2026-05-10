class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        int ans=0;
        for(int i : stones)
        {
            pq.offer(i);
        }
        while(!pq.isEmpty())
        {
            int a = pq.poll();
            if(pq.isEmpty())
            {
                return a;
            }
            else{
                int b=pq.poll();
                pq.offer(Math.abs(a-b));
            }
        }
        return 0;
    }
}