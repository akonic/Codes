class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        vector<int> v;
        sort(envelopes.begin(),envelopes.end(), [](const vector<int>& a, const vector<int>& b) {
                 if (a[0] != b[0]) return a[0] < b[0];
                 return a[1] > b[1];
             });
        v.push_back(envelopes[0][1]);
        for(int i=1;i<envelopes.size();i++)
        {
            int y=envelopes[i][1];
            if( v.back()<y)
            {
                v.push_back(y);
            }
            else{
                int idx=lower_bound(v.begin(),v.end(),y)-v.begin();
                v[idx]=y;
            }
        }
        return v.size();
    }
};