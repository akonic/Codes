class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int x=n/3;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        HashMap<Integer,Integer> pp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            if(mp.get(nums[i])>x && !pp.containsKey(nums[i]))
            {
                list.add(nums[i]);
                pp.put(nums[i],1);
            }
        }
        return list;
    }
}