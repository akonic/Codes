class Solution {

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<int[]> st = new Stack<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek()[1] > arr[i]) {

                int[] x = st.pop();

                int left;
                if (st.isEmpty()) {
                    left = x[0] + 1;
                } else {
                    left = x[0] - st.peek()[0];
                }

                ans += (long) left * x[1] * (i - x[0]);
            }

            st.push(new int[]{i, arr[i]});
        }

        while (!st.isEmpty()) {

            int[] x = st.pop();

            int left;
            if (st.isEmpty()) {
                left = x[0] + 1;
            } else {
                left = x[0] - st.peek()[0];
            }

            ans += (long) left * x[1] * (n - x[0]);
        }

        return ans;
    }

    public long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        Stack<int[]> st = new Stack<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek()[1] < arr[i]) {

                int[] x = st.pop();

                int left;
                if (st.isEmpty()) {
                    left = x[0] + 1;
                } else {
                    left = x[0] - st.peek()[0];
                }

                ans += (long) left * x[1] * (i - x[0]);
            }

            st.push(new int[]{i, arr[i]});
        }

        while (!st.isEmpty()) {

            int[] x = st.pop();

            int left;
            if (st.isEmpty()) {
                left = x[0] + 1;
            } else {
                left = x[0] - st.peek()[0];
            }

            ans += (long) left * x[1] * (n - x[0]);
        }

        return ans;
    }

    public long subArrayRanges(int[] nums) {
        long min = sumSubarrayMins(nums);
        long max = sumSubarrayMax(nums);

        return max - min;
    }
}