
class Solution {
    private void dfs(List<Character>[] ls, char p, boolean[] visited) {
        visited[p - 'a'] = true; 
        for (char c : ls[p - 'a']) {
            if (!visited[c - 'a']) { 
                dfs(ls, c, visited);
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        char[] c = baseStr.toCharArray();

        @SuppressWarnings("unchecked")
        List<Character>[] ls = (List<Character>[]) new List[26];
        for (int i = 0; i < 26; i++) {
            ls[i] = new ArrayList<>();
        }

        int n = a.length;
        for (int i = 0; i < n; i++) {
            ls[a[i] - 'a'].add(b[i]);
            ls[b[i] - 'a'].add(a[i]);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            char p = c[i];
            boolean[] visited = new boolean[26];
            dfs(ls, p, visited);
            for (int j = 0; j < 26; j++) {
                if (visited[j]) {
                    ans.append((char) (j + 'a')); // 
                    break;
                }
            }
        }
        return ans.toString();
    }
}
