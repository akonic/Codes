class Solution {
public:
    bool check(vector<int>& nums,int i,int left,int right)
    {
        vector<int> temp=nums;
        while(i<temp.size() && i>=0)
        {
            if(temp[i]==0)
            {
                if(left)
                {
                    i--;
                }
                else{
                    i++;
                }
            }
            else{
                temp[i]--;
                if(left)
                {
                    i++;
                    right=1;
                    left=0;
                }
                else{
                    i--;
                    right=0;left=1;
                }
            }
        }
        int p=0;
        for(auto& j : temp)
        {
            if(j!=0)
            {
                return false;
            }
        }
        return true;
    }
    int countValidSelections(vector<int>& nums) {
       int ans=0,n=nums.size();
       for(int j=0;j<n;j++)
       {
            if(nums[j]==0)
            {
                if(check(nums,j-1,1,0))
                {
                    ans++;
                }
                if(check(nums,j+1,0,1))
                {
                    ans++;
                }
            }
       }
       return ans;
    }
};
