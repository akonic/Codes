class Solution {
public:
    vector<string> subdomainVisits(vector<string>& cpdomains) {
        map<string,int> m;
        for(int i=0;i<cpdomains.size();i++)
        {
            string p=cpdomains[i];
            int x=0;
            string u;
            while(x<p.size() && p[x]!=' ')
            {
                u+=p[x];x++;
            }
            x++;
            m[p.substr(x)]+=stoi(u);
            while(x<p.size())
            {
                if(p[x]=='.'){
                    m[p.substr(x+1)]+=stoi(u);
                }x++;
            }

        }
        vector<string> v;
        for(auto& i  : m)
        {
            v.push_back(to_string(i.second) + ' ' + i.first);
        }
        return v;
    }
};