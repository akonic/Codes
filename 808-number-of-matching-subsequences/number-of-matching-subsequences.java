class Solution {

    private boolean check(List<Integer>[] pos, String word) {
        int prev = -1;

        for (int i = 0; i < word.length(); i++) {
            List<Integer> list = pos[word.charAt(i) - 'a'];

            if (list.isEmpty()) {
                return false;
            }

            int idx = Collections.binarySearch(list, prev + 1);

            if (idx < 0) {
                idx = -idx - 1;
            }

            if (idx == list.size()) {
                return false;
            }

            prev = list.get(idx);
        }

        return true;
    }

    public int numMatchingSubseq(String s, String[] words) {

        List<Integer>[] pos = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        int ans = 0;

        for (String word : words) {
            if (check(pos, word)) {
                ans++;
            }
        }

        return ans;
    }
}