/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        
        int ans=0;
        int n=employees.size();
        unordered_map<int,int> m;
        unordered_map<int,vector<int>> adj;
        for(auto& i : employees)
        {
            m[i->id]=i->importance;
            for(auto& j : i->subordinates)
            {
                adj[i->id].push_back(j);
            }
        }
         unordered_map<int,int> visited;
         queue<int> q;
        q.push(id);
        
        while(!q.empty())
        {
            int id=q.front();
            ans+=m[id];
            q.pop();
            visited[id]=1;
            for(auto& j : adj[id] )
            {
                if(visited[j]==0)
                {
                    q.push(j);
                }
            }
        }
        return ans;
    }
};