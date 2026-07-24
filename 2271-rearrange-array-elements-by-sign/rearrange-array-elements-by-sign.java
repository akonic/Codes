class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg= new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i : nums)
        {
            if(i<0)
            {
                neg.offer(i);
            }
            else{
                pos.offer(i);
            }
        }
        int i=0;
        while(i<n)
        {
            if(i%2==0)
            {
                ans[i]=pos.poll();
            }
            else{
                ans[i]=neg.poll();
            }
            i++;
        }
        return ans;
    }
}