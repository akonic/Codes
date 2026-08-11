class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> st =new HashSet<>();
        for(int i : nums)
        {
            st.add(i);
        }
        int i=1;
        while(st.contains(i))
        {
            i++;
        }
        return i;
    }
}