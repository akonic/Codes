class Solution {
    List<String> ans = new ArrayList<>();
    String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    void dfs(String digits, int i, StringBuilder temp) {
        if (i == digits.length()) {
            ans.add(temp.toString());
            return;
        }

        for (char p : keys[digits.charAt(i) - '0'].toCharArray()) {
            temp.append(p);
            dfs(digits, i + 1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return ans;
        ans = new ArrayList<>();
        dfs(digits, 0, new StringBuilder());
        return ans;
    }
}