class Solution {
    private static final int[][] SIGNATURES = new int[31][];
    static {
        long x = 1;
        int i = 0;
        while (x <= 1_000_000_000L) {
            SIGNATURES[i++] = digitCount((int) x);
            x *= 2;
        }
    }

    public boolean reorderedPowerOf2(int n) {
        int[] check = digitCount(n);
        for (int[] sig : SIGNATURES) {
            if (Arrays.equals(sig, check)) return true;
        }
        return false;
    }

    private static int[] digitCount(int num) {
        int[] arr = new int[10];
        while (num > 0) {
            arr[num % 10]++;
            num /= 10;
        }
        return arr;
    }
}