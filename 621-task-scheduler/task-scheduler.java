class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        int[] last = new int[26];
        Arrays.fill(last, -1);
        boolean flag = true;
        int ans = 0;
        while (flag) {
            flag = false;
            List<int[]> ls  = new ArrayList<>();
            for(int i=0;i<26;i++)
            {
                if(freq[i]>0)
                {   flag=true;
                    ls.add(new int[]{freq[i],i});
                }
            }
            ls.sort((a, b) -> Integer.compare(b[0], a[0]));
            for(int[] i : ls)
            {
                if(last[i[1]]==-1 || last[i[1]]+n<ans)
                {
                    freq[i[1]]--;
                    last[i[1]]=ans;
                    break;
                }
            }

            ans++;

        }
        return ans - 1;
    }
}