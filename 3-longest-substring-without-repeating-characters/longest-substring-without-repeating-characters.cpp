class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> v(128,0);
        int i=0,j=0,ans=0;
        while(i<s.size() && j<s.size())
        {
            if(v[s[j]]==0)
            {
                v[s[j]]++;
                j++;
                ans=max(ans,j-i);
            }
            else{
                v[s[j]]++;
                while(v[s[j]]>1)
                {
                    v[s[i]]--;i++;
                }j++;
            }
        }
        return ans;
    }
};