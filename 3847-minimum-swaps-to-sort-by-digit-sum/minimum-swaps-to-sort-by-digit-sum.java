class Solution {
    private int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

    public int minSwaps(int[] nums) {
        List<int[]> ls = new ArrayList<>();
        int n = nums.length;
        int[] arr = new int[n];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            int x = sum(nums[i]);
            ls.add(new int[] { x, i });
            mp.put(i, i);
        }
        ls.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : nums[a[1]] - nums[b[1]]);

        int c = 0;
        int[] fin = new int[n];
        for (int[] i : ls) {
            //mp.put(c,i[1]);
            fin[c] = i[1];
            c++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != fin[i]) {
                ans++;
                int j = mp.get(fin[i]);
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                mp.put(arr[i], i);
                mp.put(arr[j], j);
            }
            // System.out.println("Arr");
            // for (int j : arr) {
            //     System.out.println(j);
            // }

        }
        return ans;
    }
}