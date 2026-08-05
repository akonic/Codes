class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> ls = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ls.add(new ArrayList<>());
        }
        for(int[] i : connections)
        {
            ls.get(i[0]).add(new int[]{i[1],1});
            ls.get(i[1]).add(new int[]{i[0],0});
        }
        boolean[] reachable = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        reachable[0]=true;
        int ans=0;
        q.offer(0);
        while(!q.isEmpty())
        {
            int p = q.poll();
            for(int[] i : ls.get(p))
            {
                if(!reachable[i[0]])
                {
                    if(i[1]==1)
                    {
                        ans++;
                    }
                    reachable[i[0]]=true;
                    q.offer(i[0]);
                }
            }
        }
        return ans;
    }
}