class Solution {
public:
    int minNumberOperations(vector<int>& target) {
        int n = target.size(),p = INT_MAX, ans = 0;

        for (auto &i : target){
            p = min(p, i);
        }
        ans += p;

        for (int i = 0; i < n; i++){
            target[i] -= p;
        }
        vector<int> v;
        for (int i = 0; i < n; i++) { 
            if (i == 0) {
                if (target[i] > 0) v.push_back(target[i]);
            } 
            else {
                if (target[i] > target[i - 1])
                    v.push_back(target[i] - target[i - 1]);
            }
        }

        for (auto &x : v) ans += x;
        return ans;
    }
};