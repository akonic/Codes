class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = 0;
        Set<String> reserved = new HashSet<>();
        int x=Integer.MAX_VALUE;
        int y=Integer.MIN_VALUE;
        for (int[] i : reservedSeats) {
            reserved.add(i[0] + "_" + i[1]);
            x=Math.min(i[0],x);
            y=Math.max(i[0],y);
        }

        for (int i = x; i <= y; i++) {
            boolean flag=false;
            if (!reserved.contains(i + "_2") && !reserved.contains(i + "_3") && !reserved.contains(i + "_4")
                    && !reserved.contains(i + "_5")) {
                        flag=true;
                ans++;
            }
            if (!reserved.contains(i + "_6") && !reserved.contains(i + "_7") && !reserved.contains(i + "_8") && !reserved.contains(i + "_9")) {
                ans++;flag=true;
            } else if (flag==false && !reserved.contains(i + "_4") && !reserved.contains(i + "_5") && !reserved.contains(i + "_6")
                    && !reserved.contains(i + "_7")) {
                ans++;
            }
        }
        int p=x-1;
        ans+=2*p;
        p=n-y;
        ans+=2*p;
        return ans;
    }
}