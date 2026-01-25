class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int x=n/2;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(mp.containsKey(nums[i]))
            {
                int p=mp.get(nums[i]);
                mp.replace(nums[i],p+1);
            }
            else{
                mp.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> e : mp.entrySet())
        {
            if(e.getValue()>x)
            {
                return e.getKey();
            }
        }
        return -1;
    }
}