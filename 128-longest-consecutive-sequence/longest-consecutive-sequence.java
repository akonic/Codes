class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i : nums) {
            visited.put(i, 1);
        }
        for (Map.Entry<Integer, Integer> entry : visited.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int len=0;
            if(value==1)
            {
                while(visited.containsKey(key))
                {
                    visited.put(key,2);
                    key++;
                    len++;
                }
            }
            ans=Math.max(ans,len);
        }
        return ans;
    }
}