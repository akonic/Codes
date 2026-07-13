class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ls = new ArrayList<>();
        int[] digits = new int[] { 12, 123, 1234, 12345, 123456, 1234567, 12345678, 123456789 };
        int x = 11, p = 7;
        for (int i = 0; i < 8; i++) {
            int j = 0;
            int temp = digits[i];
            while (j <= p) {
                if (temp < low && temp <= high) {

                } else if (temp >= low && temp <= high) {
                    ls.add(temp);
                }
                j++;
                temp += x;

            }
            p--;
            x = x * 10 + 1;
        }
        return ls;
    }
}