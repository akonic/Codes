class Solution {
    private void helper(List<Integer> ls, boolean[] visited, int[] nums, List<List<Integer>> ans, int k, int j) {
        if (ls.size() == k) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = j; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                ls.add(nums[i]);
                helper(ls, visited, nums, ans, k, i + 1);
                ls.remove(ls.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        
        for(int i=0;i<n;i++)
        {
            nums[i]=i+1;
        }
       
         List<List<Integer>> ans = new ArrayList<>();
         for(int i=0;i<n;i++){
            List<Integer> ls = new ArrayList<>();
            boolean[] visited = new boolean[n];
            visited[i]=true;
            ls.add(nums[i]);
            helper(ls,visited,nums,ans,k,i+1);
            
        }
        return ans;
    }
}