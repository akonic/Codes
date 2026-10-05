class Solution {
    public static boolean isPerfectSquare(long num) {
        if (num < 0) {
            return false;
        }
        long sqrt = (long) Math.sqrt(num);
        return (sqrt * sqrt == num);
    }
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            long j = c - i * i;
            if (isPerfectSquare(j)) {
                return true;
            }
        }
        return false;
    }
}