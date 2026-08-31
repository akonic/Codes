class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int i = 0;

        while (i < n) {
            char ch = chars[i];
            int count = 0;

            while (i < n && chars[i] == ch) {
                i++;
                count++;
            }

            chars[write++] = ch;

            if (count > 1) {
                String s = String.valueOf(count);
                for (char c : s.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}