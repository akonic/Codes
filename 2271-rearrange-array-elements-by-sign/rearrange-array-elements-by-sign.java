class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i=0,j=1;
        int n=nums.length;
        int[] ans = new int[n];
        for(int k : nums)
        {
            if(k<0)
            {
                ans[j]=k;j+=2;
            }
            else{
                ans[i]=k;i+=2;
            }
        }
        return ans;
    }
}