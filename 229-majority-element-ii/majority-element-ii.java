class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i : nums)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : mp.entrySet())
        {
            if(entry.getValue()>n/3)
            {
                ls.add(entry.getKey());
            }
        }
        return ls;
    }
}