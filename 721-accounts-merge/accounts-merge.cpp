class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        sort(accounts.begin(),accounts.end());
        vector<vector<string>> v;
        int n=accounts.size();
        map<int,int> m;
        for(int i=0;i<n;i++)
        {
            if(m[i]!=1){
                set<string> s;
                for(int k=1;k<accounts[i].size();k++)
            {
                s.insert(accounts[i][k]);
            }
            bool changed = true;
            while(changed) {
                changed = false;
                for(int j=i+1;j<n;j++)
                {
                     if(accounts[i][0]==accounts[j][0] && m[j]!=1)
                    {
                        bool flag=false;
                       
                            for(int l=1;l<accounts[j].size();l++)
                            {
                                if(s.find(accounts[j][l])!=s.end())
                                {
                                    flag=true;
                                    break; // Add break for efficiency
                                }
                            }
                        
                        if(flag)
                        {
                            m[j]=1;
                            for(int k=1;k<accounts[j].size();k++)
                            {
                                s.insert(accounts[j][k]);
                            }
                            changed = true;
                        }
                    }
                }
            }
            
            vector<string> u;
            u.push_back(accounts[i][0]);
            for(auto& h : s)
            {
                u.push_back(h);
            }
            v.push_back(u);
            }
        }
        return v;
    }
};