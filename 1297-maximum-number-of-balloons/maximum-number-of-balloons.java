class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] target = "balloon".toCharArray();
        int[] freq = new int[26];
        int n = text.length();
        for (int i = 0; i < n; i++) {
            freq[text.charAt(i) - 'a']++;
        }
        int ans = 0;
        while (true) {
            int i = 0;
            int n1 = target.length;
            while (i < n1 && freq[target[i] - 'a'] != 0) {
                freq[target[i] - 'a']--;
                i++;
            }
            if (i == n1) {
                ans++;
            } else {
                return ans;
            }
        }
        //return ans;
    }
}
