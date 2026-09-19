class Solution {

    public static double getDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}
    public boolean checkOverlap(int radius, int a, int b, int x1, int y1, int x2, int y2) {
        int x3=x2;
        int y3=y1;
        int x4=x1;
        int y4=y2;
        if(a>=x1 && a<=x2 && b>=y1 && b<=y2)
        {
           
            return true;
        }

        if(a<=x1 && b>=y1 && b<=y2)
        {
            if(Math.abs(x1-a)<=radius)
            {
                return true;
            }
        }
        if(a>=x2 && b>=y1 && b<=y2)
        {
            if(Math.abs(x2-a)<=radius)
            {
                return true;
            }
        }
        if(b<y1 && a>=x1 && a<=x2)
        {
            if(Math.abs(y1-b)<=radius)
            {
                return true;
            }
        }
        if(b>=y2 && a>=x1 && a<=x2)
        {
            if(Math.abs(y2-b)<=radius)
            {
                return true;
            }
        }
        double distance1 = getDistance(a,b,x1,y1);
        double distance2 = getDistance(a,b,x2,y2);
        double distance3 = getDistance(a,b,x3,y3);
        double distance4 = getDistance(a,b,x4,y4);

        if(distance1<=radius || distance2<=radius || distance3<=radius || distance4<=radius)
        {
            return true;
        }
        
        return false;


    }
}