class Solution {
    Set<List<Integer>> ls = new HashSet<>();
    private void helper(int[] candidates, int target,int i,List<Integer> temp)
    {
        if(target==0)
        {
           ls.add(new ArrayList<>(temp));
            return ;  
        }
        int a=0;
        for(int j=i;j<candidates.length;j++)
        {
            int newTarget = target-candidates[j];
            if(newTarget>=0)
            {
                temp.add(candidates[j]);
                helper(candidates,newTarget,j,temp);
                temp.remove(temp.size() - 1);
            }
        }
        return ;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ls.clear();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        helper(candidates,target,0,temp);
        List<List<Integer>> result = new ArrayList<>(ls);
        return result;
    }
}