class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(citations[i]==0) continue;
                if (citations[i] <= n - i ) {
                    ans = Math.max(ans, citations[i]);
                }
                else{
                    ans=Math.max(ans,n-i);
                }
            
        }
        return ans;
    }
}