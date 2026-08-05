class Solution {
    private void dfs(List<List<Integer>> ls,boolean[] infected, int i)
    {
        infected[i]=true;
        for(int j : ls.get(i))
        {
            if(!infected[j])
            {
                dfs(ls,infected,j);
            }
        }

    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++)
        {   ans1.add(i);
            ls.add(new ArrayList<>());
        }
        int m = invocations.length;
        for(int[] i : invocations)
        {
            ls.get(i[0]).add(i[1]);
        }
        boolean[] infected = new boolean[n];
        dfs(ls,infected,k);
        for(int i=0;i<n;i++)
        {
            List<Integer> temp = ls.get(i);
            for (int j : temp)
            {
                if(infected[j] && !infected[i])
                {
                    return ans1;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(!infected[i])
            {
                ans.add(i);
            }
        }
        return ans;
    }
}