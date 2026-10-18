class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int i = 0;
        int n = tasks.length;
        long ans = 0;
        Map<Integer, Long> mp = new HashMap<>();
        while (i < n) {

            if (!mp.containsKey(tasks[i])) {
                
                mp.put(tasks[i], ans);
                i++;
            } else {
                Long p = mp.get(tasks[i]);
                Long x = p + space + 1;
                if (ans < x) {
                    ans += (x - ans);
                }
              
                mp.put(tasks[i], ans);
                i++;
            }
            ans++;
        }
        return ans;
    }
}