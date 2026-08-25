class Solution {
    List<List<String>> ans = new ArrayList<>();

    private boolean check(char[] ch, int i, int j) {
        while (i < j) {
            if (ch[i] == ch[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private void helper(char[] ch, List<String> ls, int i, int j) {
        if (i > j) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int k = i; k <= j; k++) {
            if (check(ch, i, k)) {
                StringBuilder s = new StringBuilder();
                for (int l = i; l <= k; l++) {
                    s.append(ch[l]);
                }
                ls.add(s.toString());
                helper(ch, ls, k + 1, j);
                ls.remove(ls.size() - 1);
            }
            // helper(ch, ls, i, k);
            // helper(ch, ls, k + 1, j);

        }
    }

    public List<List<String>> partition(String s) {
        ans.clear();
        char[] ch = s.toCharArray();
        List<String> ls = new ArrayList<>();
        int n = ch.length;
        helper(ch, ls, 0, n - 1);
        return ans;

    }
}