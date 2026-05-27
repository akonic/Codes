class Solution {

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int x=startPos[0];
        int nx=homePos[0];
        int y=startPos[1];
        int ny=homePos[1];
        int ans=0;
        if(startPos[0]<homePos[0])
        {
            x++;
            while(x<=nx)
            {
                ans+=rowCosts[x];
                x++;
            }
        }
        if(startPos[0]>homePos[0])
        {
         
            while(nx<x)
            {
                ans+=rowCosts[nx];
                nx++;
            }
        }
        if(startPos[1]<homePos[1])
        {
            y++;
            while(y<=ny)
            {
                ans+=colCosts[y];
                y++;
            }
        }
        if(startPos[1]>homePos[1])
        {
         
            while(ny<y)
            {
                ans+=colCosts[ny];
                ny++;
            }
        }

        return ans;
    }
}