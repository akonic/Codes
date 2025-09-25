class Solution {
public:
    int numberOfPoints(vector<vector<int>>& nums) {
        map<int,int> m;
       for(auto& i : nums)
       {
            m[i[0]]++;
            m[i[1]+1]--;
       } 
       int c=0,start=-1,ans=0;
       for(auto& i:m)
       {    
            c += i.second;
            if (c > 0 && start == -1) {
                start = i.first; 
            }
            if (c == 0 && start != -1) {
                ans += i.first - start;  
                start = -1;
            }
        }
        return ans;
    }
};