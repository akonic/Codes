class Solution {
    List<String> ans = new ArrayList<>();
    private String builder(List<String> ls)
    {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<ls.size();i++)
        {
            s.append(ls.get(i));
            if(i<ls.size()-1)
            {
                s.append(" ");
            }
        }
        return s.toString();
    }
    private int helper(char[] ch, Set<String> dict, int i, int j, List<String> ls) {
        if (i == ch.length){ 
            ans.add(builder(ls));
            return 1;}
        if (j == ch.length) return 0;

        //if (dp[i][j] != -1) return dp[i][j];

        int pick = 0, skip = 0;

        if (dict.contains(new String(ch, i, j - i + 1))) {
            ls.add(new String(ch, i, j - i + 1));
            pick = helper(ch, dict, j + 1, j + 1,ls);
            ls.remove(ls.size()-1);
        }

        skip = helper(ch, dict, i, j + 1,ls);

        return  Math.max(pick, skip);
    }

     public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        ans.clear();
        List<String> ls = new ArrayList<>();
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int x = helper(s.toCharArray(), new HashSet<>(wordDict), 0, 0,ls);

        return ans;
    }
}