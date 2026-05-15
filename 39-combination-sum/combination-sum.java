class Solution {
   

    private void helper(List<List<Integer>> ls,int[] candidates, int target, int i, List<Integer> temp) {
        if (target == 0) {
            ls.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            int newTarget = target - candidates[j];
            if (newTarget < 0)
                break;
            temp.add(candidates[j]);
            helper(ls,candidates, newTarget, j, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ls,candidates, target, 0, new ArrayList<>());
        return ls;
    }
}