class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        if(s.size()<10)
        {
            return {};
        }
        vector<string> v;
        unordered_map<string,int> m;
        for(int i=0;i<s.size()-9;i++)
        {
            string p=s.substr(i, 10);
            m[p]++;
        }
        for(auto& i : m)
        {
            if(i.second>1)
            {
                v.push_back(i.first);
            }
        }
        return v;

    }
};