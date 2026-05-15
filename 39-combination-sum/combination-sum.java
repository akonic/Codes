class Solution {
    Set<List<Integer>> ls = new HashSet<>();
    private int helper(int[] candidates, int target,int i,List<Integer> temp)
    {
        if(target==0)
        {
           ls.add(new ArrayList<>(temp));
            return 0;  
        }
        int a=0;
        for(int j=i;j<candidates.length;j++)
        {
            int newTarget = target-candidates[j];
            if(newTarget>=0)
            {
                temp.add(candidates[j]);
                a+=helper(candidates,newTarget,j,temp);
                temp.remove(temp.size() - 1);
            }
        }
        return a;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ls.clear();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        int p=helper(candidates,target,0,temp);
        List<List<Integer>> result = new ArrayList<>(ls);
        return result;
    }
}