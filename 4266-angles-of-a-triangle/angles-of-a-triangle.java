class Solution {
    public double[] internalAngles(int[] sides) {
        double[] ans = new double[3];
        int x=sides[0],y=sides[1],z=sides[2];
        if(x+y>z && x+z>y && y+z>x)
        {
            double a = x*1.00;
            double b = y*1.00;
            double c = z*1.00;
            double angleA_rad = Math.acos((b*b + c*c - a*a) / (2 * b * c));
            double angleB_rad = Math.acos((a*a + c*c - b*b) / (2 * a * c));
            double angleC_rad = Math.acos((a*a + b*b - c*c) / (2 * a * b));

            // Convert radians to degrees
            double angleA = Math.toDegrees(angleA_rad);
            double angleB = Math.toDegrees(angleB_rad);
            double angleC = Math.toDegrees(angleC_rad);
       
            ans[0]=angleA;
            ans[1]=angleB;
            ans[2]=angleC;
            Arrays.sort(ans);
            return ans;
        }
        return new double[]{};
       
    }
}