class Solution {
    public long[] distance(int[] nums) {

        int n = nums.length;
        long[] arr = new long[n];
        Arrays.fill(arr,0);
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }

            map.get(nums[i]).add(i);
        }

        for (int key : map.keySet()) {

            if (map.get(key).size() == 1) {
                arr[map.get(key).get(0)] = 0;
            } else {
                List<Integer> cur = map.get(key);
                System.out.println(key);
                int sz = cur.size();
                long[] pre = new long[sz];
                long sum = 0;
                for (int i = 0; i < sz; i++) {
                    sum += cur.get(i);
                    pre[i] = sum;
                }
                for (int i = 0; i < sz; i++) {
                    long preSum=pre[sz - 1] - pre[i];
                    long sub1=(long)(sz - i - 1) * (long)cur.get(i);
                    
                    long forward = preSum-sub1;
                    long backward = 0;
                    if (i - 1 >= 0) {
                        backward = (long) i * cur.get(i) - pre[i - 1];
                    }
                    //System.out.println(forward+ " " + backward);
                    arr[cur.get(i)]=forward+backward;
                }

            }

        }

        return arr;
    }
}

/*

    1 -> 0, 2, 3
         5. 3. 4

    2 -> 4
    3 -> 1

*/