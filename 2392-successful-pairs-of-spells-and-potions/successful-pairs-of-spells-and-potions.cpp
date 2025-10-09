class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions,
                                long long success) {
        sort(potions.begin(), potions.end());
        vector<int> v;
        int m = potions.size();
        for (auto i : spells) {
            long long x = success / i;
            if (success % i != 0) {
                x++;
            }
            auto it = lower_bound(potions.begin(), potions.end(), x);

            int index = it - potions.begin();
            if (it == potions.end())
                v.push_back(0);
            else
                v.push_back(m - index);
        }
        return v;
    }
};