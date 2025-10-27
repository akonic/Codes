class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        vector<int> v;
        for(auto& i : bank)
        {
            int c=0;
            for(auto& j : i)
            {
                if(j=='1')
                {
                    c++;
                }
            }
            if(c>0)
            {
                v.push_back(c);
            }
        }
        int p=0;
        for(int i=1;i<v.size();i++)
        {
            p+=(v[i]*v[i-1]);
        }
        return p;
    }
};