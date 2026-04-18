class Solution {
    public int maxOperations(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp =new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int target=k-nums[i];
          
            int q=mp.getOrDefault(nums[i],0);
            if(q>=1){
                  int p=mp.getOrDefault(target,0);
            if(target==nums[i])
            {
                if(p>=2){
                 mp.put(nums[i], mp.getOrDefault(nums[i], 0) -2);
                 ans++;
                }
            }
            else if(p>=1 && q>=1)
            {
                 mp.put(target, mp.getOrDefault(target, 0) -1);
                 mp.put(nums[i], mp.getOrDefault(nums[i], 0) -1);
                 ans++;
            }
            }
        }
        return ans;
    }
}