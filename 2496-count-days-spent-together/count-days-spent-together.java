class Solution {
    private int[] solve(int m1,int d1,int m2,int d2)
    {
        if(m1>m2)
        {
            return new int[]{m1,d1};
        }
        else if(m1==m2)
        {
            return new int[]{m1,Math.max(d1,d2)};
        }
        return new int[]{m2,d2};
    }
        private int[] solve2(int m1,int d1,int m2,int d2)
    {
        if(m1>m2)
        {
            return new int[]{m2,d2};
        }
        else if(m1==m2)
        {
            return new int[]{m1,Math.min(d1,d2)};
        }
        return new int[]{m1,d1};
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] part1 = arriveAlice.split("-");
        int m1 = Integer.parseInt(part1[0]);
        int d1 = Integer.parseInt(part1[1]);
        String[] part2 = leaveAlice.split("-");
        int m2 = Integer.parseInt(part2[0]);
        int d2 = Integer.parseInt(part2[1]);
        String[] part3 = arriveBob.split("-");
        int m3 = Integer.parseInt(part3[0]);
        int d3 = Integer.parseInt(part3[1]);
        String[] part4 = leaveBob.split("-");
        int m4 = Integer.parseInt(part4[0]);
        int d4 = Integer.parseInt(part4[1]);

        int[] get1 = solve(m1,d1,m3,d3);
        int[] get2 = solve2(m2,d2,m4,d4);
        int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans=0;
        //System.out.println(get1[0]+" "+get1[1]);
        //System.out.println(get2[0]+" "+get2[1]);
        if(get2[0]<get1[0])
        {
            return 0;
        }
        if(get2[0]==get1[0] && get2[1]<get1[1])
        {
            return 0;
        }
        else if(get2[0]==get1[0])
        {
            return get2[1]-get1[1]+1;
        }
        for(int i=get1[0]+1;i<get2[0];i++)
        {
            ans+=month[i-1];
        }
        //System.out.println(ans);
         ans+=month[get1[0]-1]-get1[1];
         ans+=get2[1];

        return ans+1;
    }
}