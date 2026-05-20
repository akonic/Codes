class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] pre1 = new boolean[51];
        boolean[] pre2 = new boolean[51];
        int[] ans = new int[n];
        int c = 0;

        for (int i = 0; i < n; i++) {
            pre1[A[i]] = true;
            pre2[B[i]] = true;

            if (pre1[A[i]] && pre2[A[i]])
                c++;
            if (A[i] != B[i] && pre1[B[i]] && pre2[B[i]])
                c++;

            ans[i] = c;
        }
        return ans;

    }
}