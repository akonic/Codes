class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<Math.min(k+1,n);i++)
        {
            if(mp.containsKey(nums[i]) && mp.get(nums[i])>0)
            {
                return true;
            }
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(int i=k+1;i<n;i++)
        {
           mp.put(nums[i-k-1],mp.getOrDefault(nums[i-k-1],0)-1);
            if(mp.containsKey(nums[i]) && mp.get(nums[i])>0)
            {
                return true;
            }
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        return false;
    }
}