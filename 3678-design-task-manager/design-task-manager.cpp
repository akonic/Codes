class TaskManager {
public:
    priority_queue<pair<int,int>> pq; // priority,taskId
    map<int,pair<int,int>> m; // taskId,{userid,priority}
    TaskManager(vector<vector<int>>& tasks) {
        for(auto& i : tasks)
        {
            int a=i[0],b=i[1],c=i[2];
            pq.push({c,b});
            m[b]={a,c};
        }
    }
    
    void add(int userId, int taskId, int priority) {
            pq.push({priority,taskId});
            m[taskId]={userId,priority};
    }
    
    void edit(int taskId, int newPriority) {
        auto it = m.find(taskId);
        if(it == m.end()) return;             
        int userId = it->second.first;
        it->second.second = newPriority;       
        pq.push({newPriority, taskId});        
    }
    
    void rmv(int taskId) {
        m.erase(taskId);
    }
    
    int execTop() {
       while(!pq.empty()) {
            auto top = pq.top();
            int heapPriority = top.first;
            int taskId = top.second;

            auto it = m.find(taskId);
            if(it == m.end()) {
                pq.pop();
                continue;
            }
            int curPriority = it->second.second;
            if(curPriority != heapPriority) {
                pq.pop();
                continue;
            }

            int userId = it->second.first;
            pq.pop();
            m.erase(it); 
            return userId;
        }
        return -1;
        
    }
};

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager* obj = new TaskManager(tasks);
 * obj->add(userId,taskId,priority);
 * obj->edit(taskId,newPriority);
 * obj->rmv(taskId);
 * int param_4 = obj->execTop();
 */