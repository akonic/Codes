class Solution {
public:
    void dfs(vector<vector<int>>& rooms, vector<bool>& visited, int i, int& c) {
        c++;
        visited[i] = 1;
        for (int j = 0; j < rooms[i].size(); j++) {
            if (!visited[rooms[i][j]]) {
                dfs(rooms, visited, rooms[i][j], c);
            }
        }
    }
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n = rooms.size();
        vector<bool> visited(n, 0);
        int c = 0;
        dfs(rooms,visited,0,c);
        if (c == n) {
            return true;
        }
        return false;
    }
};