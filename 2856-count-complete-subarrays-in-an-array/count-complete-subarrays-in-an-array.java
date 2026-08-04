class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int n = nums.length;
        for (int i : nums) {
            st.add(i);
        }
        int count = st.size();
        st.clear();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> temp = new HashSet<>();

            temp.add(nums[i]);
            for (int j = i ; j < n; j++) {
                temp.add(nums[j]);
                if (temp.size() == count) {
                    ans++;
                } else if (temp.size() > count) {
                    break;
                }
            }
        }
        return ans;
    }
}