class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans=0;
        int j=1;
        while(n>=8)
        {
            ans+=(8*j);
            j++;
            n-=8;
            System.out.println(n);
        }
//System.out.println(n+"-");
        ans+=(j)*n;
        return ans;
    }
}