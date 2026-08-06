class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> q = new ArrayDeque<>();
        int[] freq = new int[26];
        char[] ch = s.toCharArray();
        for (char c : ch) {
            freq[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        int n = ch.length;
        int i = 0;
        while (i < n) {
            freq[ch[i]-'a']--;
            if (!visited[ch[i] - 'a']) {
                while (!q.isEmpty() && ch[i] < q.peek() && freq[q.peek() - 'a'] > 0) {
                    char temp = q.pop();
                    visited[temp - 'a'] = false;

                }
                q.push(ch[i]);
                visited[ch[i] - 'a'] = true;
            }
            i++;
        }
        StringBuilder st = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.pop();

            st.append(c);
        }

        return st.reverse().toString();

    }
}
