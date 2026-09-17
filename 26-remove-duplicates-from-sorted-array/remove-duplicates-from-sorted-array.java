class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n];
        int j = 0, c = 0;
        for (int i = 0; i < n ; i++) {
            if (i+1<n && nums[i] == nums[i + 1]) {
                check[i] = true;
                c++;
                while (i + 1 < n && nums[i] == nums[i + 1]) {
                    i++;
                }
                //i--;
            } else {
                c++;
                check[i] = true;
            }
        }
        j = 0;
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                j = i;
                while (j < n && check[j] == false) {
                    j++;
                }
                if (j < n) {
                    check[j] = false;
                    nums[i] = nums[j];
                    check[i] = true;
                }
            }
        }

        return c ;

    }
}