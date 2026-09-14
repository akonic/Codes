class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1=rec1[0],x2=rec1[2];
        int y1=rec1[1],y2=rec1[3];

        int x3=rec2[0],x4=rec2[2];
        int y3=rec2[1],y4=rec2[3];
        if(x3>=x2 || x4<=x1)
        {
            return false;
        }
        if(y4<=y1 || y3>=y2)
        {
            return false;
        }
        return true;
    }
}