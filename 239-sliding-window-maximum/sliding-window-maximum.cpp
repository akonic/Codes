class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        multiset<int, greater<int>> pq;
       vector<int> v;
       for(int i=0;i<k;i++)
       {
            pq.insert(nums[i]);
       }
       int maxElement;
       for(int i=k;i<nums.size();i++)
       {
           maxElement = *pq.begin();
           v.push_back(maxElement);
           auto it = pq.find(nums[i-k]);
            if (it != pq.end())
            {pq.erase(it);}
            pq.insert(nums[i]);
       }
       maxElement = *pq.begin();
           v.push_back(maxElement);
       return v;
    }
};