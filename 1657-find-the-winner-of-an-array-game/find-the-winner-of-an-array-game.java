class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int ind = 0, x = arr[0];
        for (int i = 0; i < n; i++) {
            if (x < arr[i]) {
                x = arr[i];
                ind = i;
            }
        }

        if (k >= n) {
            return x;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i : arr)
            dq.addLast(i);

        boolean flag = false;
        while (true) {
            int front = dq.pollFirst();
            int c = 0;
            if (flag) {
                c++;
            }
            if (c == k) {
                return front;
            }
            while (c < k && front > dq.getFirst()) {
                int top = dq.pollFirst();
                dq.addLast(top);
                c++;
                if (c == k) {
                    return front;
                }
            }
            flag = true;
            dq.addLast(front);

        }

        //return -1;
    }
}