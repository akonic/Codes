class Solution {
    public boolean canAliceWin(int n) {
        int p = 0, x = 10;
        while (n > 0) {
            if (n < x) {
                if (p % 2 == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            n -= x;
            x--;
            p++;

        }
        if (p % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
