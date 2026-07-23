class Solution {
    
    public int integerReplacement(int n) {
        int ans=0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));
        Set<Long> visited = new HashSet<>();
        pq.offer(new long[]{0,n});
        while(!pq.isEmpty())
        {
            long[] top = pq.poll();
            long num = top[1];
            long cost = top[0];
            if(num==1)
            {
                return (int)cost;
            }
            if (!visited.add(num))
                continue;
                
            if(num%2==0)
            {
                pq.offer(new long[]{cost+1,num/2});
            }
            else{
                pq.offer(new long[]{cost+1,num-1});
               
                pq.offer(new long[]{cost+1,num+1});
            }
        }
        return ans;
    }
}