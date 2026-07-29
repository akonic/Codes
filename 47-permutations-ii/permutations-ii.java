class Solution {
    private void helper(Set<List<Integer>> st, List<Integer> ls, int[] nums, boolean[] vis) {
        if (ls.size() == vis.length) {
            st.add(new ArrayList<>(ls));
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == false) {
                vis[i] = true;
                ls.add(nums[i]);
                helper(st, ls, nums, vis);
                ls.remove(ls.size() - 1);
                vis[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            ans.add(list);
            return ans;
        }
        Set<List<Integer>> st = new HashSet<>();

        boolean[] vis = new boolean[n];
        List<Integer> ls = new ArrayList<>();
        helper(st, ls, nums, vis);
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> temp : st) {
            ans.add(new ArrayList<>(temp));
        }
        st.clear();
        return ans;
    }
}