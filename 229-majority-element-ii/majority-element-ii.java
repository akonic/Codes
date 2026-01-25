class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int x=n/3;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer,Integer> e : mp.entrySet())
        {
            if(e.getValue()>x)
            {
                list.add(e.getKey());
            }
        }
        return list;
    }
}