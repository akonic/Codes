class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit,
                            vector<int>& worker) {
        int n = difficulty.size();
        vector<pair<int, int>> jobs;

        for (int i = 0; i < n; i++) {
            jobs.push_back({difficulty[i], profit[i]});
        }

        sort(jobs.begin(), jobs.end());

        for (int i = 1; i < n; i++) {
            jobs[i].second = max(jobs[i].second, jobs[i - 1].second);
        }

        int total = 0;

        for (int w : worker) {
            auto it = upper_bound(jobs.begin(), jobs.end(), make_pair(w, INT_MAX));
            if (it == jobs.begin()) continue; 
            --it;
            total += it->second;
        }

        return total;
    }
};