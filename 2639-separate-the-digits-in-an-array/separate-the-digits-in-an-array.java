class Solution {
    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x = nums[i];
            List<Integer> pp = new ArrayList();
            while(x>0)
            {
              pp.add(x%10);
              x/=10;
            }
            Collections.reverse(pp);
             ls.addAll(pp);
        }
       
       return ls.stream().mapToInt(Integer::intValue).toArray();
    }
}