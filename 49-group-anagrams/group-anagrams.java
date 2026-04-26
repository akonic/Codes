class Solution {
    private boolean areSame(String temp, String temp2) {
        int[] map = new int[26];
        for (int i = 0; i < temp.length(); i++) {
            map[temp.charAt(i) - 'a']++;
        }
        for (int i = 0; i < temp2.length(); i++) {
            map[temp2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ls = new ArrayList<>();
        int n = strs.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            String temp = strs[i];
            if (visited[i] == 0) {
                visited[i] = 1;
                List<String> ls2 = new ArrayList<>();
                ls2.add(temp);
                for (int j = i + 1; j < n; j++) {
                    String temp2 = strs[j];
                    if (visited[j] == 0 && areSame(temp, temp2)) {
                        visited[j] = 1;
                        ls2.add(temp2);
                    }
                }
                ls.add(ls2);
            }
        }
        return ls;
    }
}