class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int[] result2 = new int[n];
        int[] result1 = new int[m];
        Arrays.fill(result1,-1);
        Arrays.fill(result2,-1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++)
        {
            while(st.size()>0 && nums2[i]>nums2[st.peek()])
            {
                int top = st.pop();
                result2[top]=nums2[i];
            }
            st.push(i);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    result1[i]=result2[j];
                    break;
                }
            }
        }
        return result1;
    }
}