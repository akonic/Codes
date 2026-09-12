class Solution {
    public int reverse(int x) {
        int n = x;
        List<Integer> ls = new ArrayList<>();
        int u=1;
        if(n<0)
        {
            u=-1;
            n*=-1;
        }
        while (n > 0) {
            ls.add(n % 10);
            n /= 10;
        }
        Collections.reverse(ls);
        long h=0;
        int p = 1;
        for (int i : ls) {
            h += ((long)p * (long)i);
            p *= 10;
        }
        if(h>Integer.MAX_VALUE)
        {
            return 0;
        }
        return u*(int)h;
    }
}