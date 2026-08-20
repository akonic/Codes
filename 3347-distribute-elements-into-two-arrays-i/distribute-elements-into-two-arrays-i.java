class Solution {
    public int[] resultArray(int[] nums) {
       List<Integer> ls = new ArrayList<>();
       List<Integer> ps = new ArrayList<>();
       Stack<Integer> st = new Stack<>();
       Stack<Integer> pt = new Stack<>();
        int i=0;
        int n=nums.length;
        while(i<n)
        {
            if(st.size()==0)
            {
                st.push(nums[i]);i++;
            }
            else if(pt.size()==0)
            {
                pt.push(nums[i]);i++;
            }
            if(st.size()>0 && pt.size()>0 && st.peek()>pt.peek())
            {
                st.push(nums[i]);i++;
            }
            else{
                pt.push(nums[i]);i++;
            }
        }
        while(!st.isEmpty())
        {
            ls.add(st.pop());
        }
        while(!pt.isEmpty())
        {
            ps.add(pt.pop());
        }
        Collections.reverse(ls);
        Collections.reverse(ps);
        int[] ans = new int[n];
        i=0;
        for(int j : ls)
        {
            ans[i]=j;i++;
        }
        for(int j : ps)
        {
            ans[i]=j;i++;
        }
        return ans;
    }
}