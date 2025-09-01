class Solution {
public:
    int n, m;

  bool func(vector<vector<char> > & v, int i, int j, string& s, int ind)
 {
    if(ind == s.length())
    return true;

    if(i<0|| j<0 || i>= v.size()||  j >= v[0].size()|| s[ind] != v[i][j])
    return false;

    bool ans = false;

    char x = v[i][j];
    v[i][j] = ' ';

    // Check all four possible directions (down, up, right, left)
    ans |= func(v, i+1 , j , s , ind+1);
    ans |= func(v, i-1 , j , s , ind+1);
    ans |= func(v, i , j+1 , s , ind+1);
    ans |= func(v, i , j-1 , s , ind+1);

    v[i][j]= x ;
    return ans;

 }
    

    bool exist(vector<vector<char>>& board, string word) {
        n = board.size();
        m = board[0].size();
        
        if (n * m < word.size()) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word[0]) {
                   if(func(board, i, j , word , 0))
                    return true;
                }
            }
        }
        return false;
    }
};