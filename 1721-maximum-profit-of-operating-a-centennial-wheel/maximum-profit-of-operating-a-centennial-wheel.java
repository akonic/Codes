class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int rotations = 0;
        int totalPeople = 0;
        int currPeople = 0;
        int ans = 0;
        int i = 0;
        int n = customers.length;
        int rot = -1;
        while (i < n || currPeople > 0) {
            if (i < n) {
                currPeople += customers[i++];
            }
            int x = (int) Math.min(4, currPeople);
            totalPeople += x;
            currPeople -= x;
            rotations++;

            long currProfit = totalPeople * boardingCost - (long) rotations * runningCost;
            if (currProfit > ans) {
                ans = (int)currProfit;
                rot = rotations;
            }
        }
        return rot;
    }
}