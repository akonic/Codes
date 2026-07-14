class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int rotations = 0;
        int totalPeople = 0;
        int currPeople=0;
        int ans=0;
        int i=0;
        int n = customers.length;
        int rot=-1;
        boolean ran=true;
        while(ran)
        {
            ran=false;
            if(rotations>=i && i<n)
            {
                currPeople+=customers[i];
                i++;
            }
            int x= Math.min(4,currPeople);
            totalPeople+=x;
            currPeople-=x;
            rotations++;
            int currProfit=totalPeople*boardingCost - rotations*runningCost;
            if(currProfit>ans)
            {
                ans=currProfit;
                rot=rotations;
            }
            if(currPeople>0 || i<n)
            {
                ran=true;
            }

        }
        return rot;
    }
}