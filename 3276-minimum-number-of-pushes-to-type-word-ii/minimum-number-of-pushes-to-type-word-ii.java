class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            freq[word.charAt(i) - 'a']++;
        }
        List<Integer> ls = new ArrayList<>();
        for (int i : freq) {
            if (i != 0) {
                ls.add(i);
            }
        }
        Collections.sort(ls, Collections.reverseOrder());
        int j = 0, ans = 0;
        for (int i : ls) {
            
            ans += ((j / 8) + 1) * i;
            j++;
        }
        return ans;
    }
}