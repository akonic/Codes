import java.math.BigInteger;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
        BigInteger[] arr = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new BigInteger(nums[i]);
        }
        Arrays.sort(arr);
        return arr[n - k].toString();
    }
}