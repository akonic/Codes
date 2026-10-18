class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int n = tasks.length;
        long ans=0;
        Map<Integer, Long> mp = new HashMap<>();
        for(int i : tasks) {

            if (!mp.containsKey(i)) {              
              mp.put(i, ans);               
            } else {
                Long p = mp.get(i);
                Long x = p + space + 1;
                if (ans < x) {
                    ans += (x - ans);
                }          
                mp.put(i, ans);
            }
            ans++;
        }
        return ans;
    }
}