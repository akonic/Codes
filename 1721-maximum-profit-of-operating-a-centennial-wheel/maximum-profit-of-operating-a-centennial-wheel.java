class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int rotations = 0;
        int totalPeople = 0;
        //int profit=0;
        int currPeople=0;
        int ans=0;
        //int[] cart = new int[4];
        //int cartIndex=0;
        //Arrays.fill(cart,0);
        int i=0;
        int n = customers.length;
        //boolean ran=0;
        int sum=0;
        int rot=-1;
        for(int j : customers)
        {
            sum+=j;
        }
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
            //System.out.println(totalPeople+" "+currProfit+" "+i+" "+rotations);

        }
        return rot;
    }
}