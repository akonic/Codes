class Solution {
    public int removeDuplicates(int[] nums) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int n = nums.length;
        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int i = 0;
        int j = n - 1;
        int ans=0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
           int key = entry.getKey();
           int value= entry.getValue();
           if(value<=2)
           {
                while(value>0)
                {ans++;
                    nums[i]=key;
                    i++;
                    value--;
                }
           }
           else{
            ans+=2;
                nums[i]=key;
                nums[i+1]=key;
                i+=2;
           }
        }
        return ans;
    }
}