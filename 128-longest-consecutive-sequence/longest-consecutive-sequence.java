class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        
        int ans = 0;
        for (int key : set) {
            if (!set.contains(key - 1)) { 
                int len = 0;
                while (set.contains(key)) {
                    key++;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}