class Solution {
    Set<String> ls = new HashSet<>();

    private int check(String s) {
        int c = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                c++;
            } else if (s.charAt(i) == ')') {
                c--;
            }

            if (c < 0) {
                ans++;
                c = 0;
            }
        }
        if (c > 0) {
            ans += c;
        }
        return ans;

    }

    private boolean check2(boolean[] flag, String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag[i]) {
                if (s.charAt(i) == '(') {
                    c++;
                } else if (s.charAt(i) == ')') {
                    c--;
                }

                if (c < 0) {
                    return false;
                }
            }
        }
        if (c > 0) {
            return false;
        }
        return true;
    }

    private void helper(String s, boolean[] flag, int i, int c) {
        if (c < 0) {
            return;
        }
        if (i == s.length()) {
            if (c == 0 && check2(flag, s)) {
                StringBuilder ans = new StringBuilder();
                for (int k = 0; k < s.length(); k++) {
                    if (flag[k]) {
                        ans.append(s.charAt(k));
                    }
                }
                ls.add(ans.toString());

            }
            return;
        }

        if (s.charAt(i) == '(' || s.charAt(i) == ')') {
            flag[i] = false;
            helper(s, flag, i + 1, c - 1);
            flag[i] = true;
            helper(s, flag, i + 1, c);

        } else {
            helper(s, flag, i + 1, c);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        ls.clear();
        List<String> ans = new ArrayList<>();
        int n = s.length();
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        int c = check(s);
        System.out.println(c);
        helper(s, flag, 0, c);
        ans.addAll(ls);
        return ans;
    }
}