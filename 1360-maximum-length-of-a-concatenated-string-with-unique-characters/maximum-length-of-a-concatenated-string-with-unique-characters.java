class Solution {
    private boolean isUnique(String s, int[] freq) {
        for (int i = 0; i < s.length(); i++) {
            int p = s.charAt(i) - 'a';
            if (freq[p] > 0) {
                return false;
            }
        }
        return true;
    }

    private int helper(List<String> unique, int i, int[] freq) {
        if (i == unique.size()) {
            return 0;
        }
        int pick = 0, skip = 0;
        if (isUnique(unique.get(i), freq)) {
            char[] ch = unique.get(i).toCharArray();
            int len = ch.length;
            for (int j = 0; j < len; j++) {
                freq[ch[j] - 'a']++;
            }
            pick = len + helper(unique, i + 1, freq);
            for (int j = 0; j < len; j++) {
                freq[ch[j] - 'a']--;
            }
        }
        skip = helper(unique, i + 1, freq);

        return Math.max(pick, skip);
    }

    public int maxLength(List<String> arr) {
        int n = arr.size();
        int[][] freq = new int[n][26];
        for (int[] i : freq) {
            Arrays.fill(i, 0);
        }
        List<String> unique = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            char[] temp = arr.get(i).toCharArray();
            for (char c : temp) {
                freq[i][c - 'a']++;
                if (freq[i][c - 'a'] > 1) {
                    flag = false;
                }
            }
            if (flag) {
                unique.add(arr.get(i));
            }
        }

        int[] check = new int[26];
        return helper(unique, 0, check);

    }
}