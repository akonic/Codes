class Solution {
    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        List<Integer> ls = new ArrayList<>();
        for(int i=n-1;i>=0;i--)
        {
            int x = nums[i];
           
            while(x>0)
            {
              ls.add(x%10);
              x/=10;
            }
           
        }
       Collections.reverse(ls);
       return ls.stream().mapToInt(Integer::intValue).toArray();
    }
}