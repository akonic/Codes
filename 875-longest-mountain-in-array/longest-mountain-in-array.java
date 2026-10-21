class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length, ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                int j = i;
                while (j < n && arr[j] > arr[j - 1])
                    j++;
                if (j == n)
                    break;
                boolean flag = false;
                while (j < n && arr[j] < arr[j - 1]) {
                    flag = true;
                    j++;
                }
                if (flag)
                    ans = Math.max(ans, j - i + 1);
                i = j - 1;
            }
        }
        return ans;
    }
}