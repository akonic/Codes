class Solution {
    public int maxOperations(int[] nums, int k) {
        int n=nums.length;
        int ans=0;
        Arrays.sort(nums);
        int i=0,j=n-1;
        while(i<j)
        {
            int target=nums[i]+nums[j];
            if(target==k)
            {
                ans++;i++;j--;
            }
            else if(target<k){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}