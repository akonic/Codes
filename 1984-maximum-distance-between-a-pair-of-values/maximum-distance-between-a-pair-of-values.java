class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int j=0,i=0;
        int ans = 0;
        int n = nums1.length;
        int m = nums2.length;
        while(i<n && j<m)
        {
            while(i<n && j<m && nums1[i]>nums2[j])
            {
                i++;
            }
            while(i<n && j<m && nums1[i]<=nums2[j])
            {
                ans=Math.max(ans,j-i);
                j++;
            }
        }
        return ans;
    
    }
}