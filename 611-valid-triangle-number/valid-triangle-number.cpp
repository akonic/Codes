class Solution {
public:

    int triangleNumber(vector<int>& nums) {
        int c=0,n=nums.size();
        sort(nums.begin(),nums.end());
        for(int k=n-1;k>=2;k--)
        {
            int i=0,j=k-1;
            while(i<j)
            {
                if ((long long)nums[i] + nums[j] > nums[k]) {
                    c += (j - i); 
                    --j;
                } else {
                    ++i;
                }
            }

        }
        return c;
    }
};