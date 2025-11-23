class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        int sum = 0;
        vector<int> two, one;

        for (auto& i : nums) {
            
                sum += i;
            if (i % 3 == 1) {
                one.push_back(i);
            } else if(i%3==2){
                two.push_back(i);
            }
        }
        if (sum % 3 == 0) 
            {return sum;}
        
        sort(one.begin(), one.end());
        sort(two.begin(), two.end());
      
        int result = 0;
        if (sum % 3 == 1) {
            int remove1 = one.size() >= 1 ? one[0] : INT_MAX;
            int remove2 = two.size() >= 2 ? two[0] + two[1] : INT_MAX;
            result = sum - min(remove1, remove2);
        } 
        else { 
            int remove1 = two.size() >= 1 ? two[0] : INT_MAX;
            int remove2 = one.size() >= 2 ? one[0] + one[1] : INT_MAX;
            result = sum - min(remove1, remove2);
        }

        return result < 0 ? 0 : result;

    }
};
