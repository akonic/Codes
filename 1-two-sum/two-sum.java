class Solution {
    public int[] twoSum(int[] nums, int target) {
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        int n=nums.length;
        int[] arr = new int[2];
        for(int i =0;i<n;i++)
        {
           mp.put(nums[i],i);
        }
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(target-nums[i]) && i!=mp.get(target-nums[i]))
            {
               arr[0]=i;
               arr[1]=mp.get(target-nums[i]);
               return arr;
            }
        }
        return arr;
    }
}