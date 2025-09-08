class Solution {
public:
    bool containsZero(int num) {
        if (num == 0)
            return true; 
        while (num > 0) {
            if (num % 10 == 0)
                return true;
            num /= 10;
        }
        return false;
    }
    vector<int> getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (!containsZero(i) && !containsZero(n-i)) {
                return {i, n - i};
            }
        }
        return {};
    }
};