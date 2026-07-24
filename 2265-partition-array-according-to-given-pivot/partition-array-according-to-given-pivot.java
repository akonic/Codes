class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> less = new LinkedList<>();
        Queue<Integer> greater  = new LinkedList<>();
        int n=nums.length;
        int count=0;
        int[] ans = new int[n];
        for(int i : nums)
        {
            if(i<pivot)
            {
                less.offer(i);
            }
            else if(i>pivot)
            {
                greater.offer(i);
            }
            else{
                count++;
            }
        }
        int i=0;
        while(i<n)
        {
            while(!less.isEmpty())
            {
                ans[i]=less.poll();
                i++;
            }
            while(count>0)
            {
                count--;
                ans[i]=pivot;
                i++;
            }
            while(!greater.isEmpty())
            {
                ans[i]=greater.poll();
                i++;
            }
        }
        return ans;
    }
}