class Solution {
public:
int eggDrop(int n, int k) {

    vector<int> dp(n + 1, 0);

    int cnt = 0;

    while (dp[n] < k) {
        cnt++;

        for (int i = n; i > 0; i--) {
            dp[i] += 1 + dp[i - 1];
        }
    }
    return cnt;
}
    int superEggDrop(int k, int n) {
        return eggDrop(k,n);
    }
};