class Solution {
   
    private void helper(List<Integer> ls,boolean[] visited,int[] nums,List<List<Integer>> ans)
    {
        if(ls.size()==visited.length)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<visited.length;i++)
        {
            if(visited[i]==false)
            {
                visited[i]=true;
                ls.add(nums[i]);
                helper(ls,visited,nums,ans);
                ls.remove(ls.size()-1);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> ls = new ArrayList<>();
         List<List<Integer>> ans = new ArrayList<>();
        helper(ls,visited,nums,ans);
        return ans;
    }
}