class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        int x = n / 8;
        return 8 * (x * (x + 1)) / 2 + (x + 1) * (n % 8);

    }
}