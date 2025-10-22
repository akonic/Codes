class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        int n = moves.size();
        vector<vector<char>> board(3, vector<char>(3, ' '));

        for (int i = 0; i < n; i++) {
            int x = moves[i][0], y = moves[i][1];
            board[x][y] = (i % 2 == 0) ? 'X' : 'O';
        }

        if (board[0][0] != ' ') { 
            int i = 0, j = 0;
            while (i < 3 && j < 3 && board[i][j] == board[0][0]) { i++; j++; }
            if (i == 3) return (board[0][0] == 'X') ? "A" : "B";
        }

        if (board[0][2] != ' ') { 
            int i = 0, j = 2;
            while (i < 3 && j >= 0 && board[i][j] == board[0][2]) { i++; j--; }
            if (i == 3) return (board[0][2] == 'X') ? "A" : "B";
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ') { 
                int j = 0;
                while (j < 3 && board[j][i] == board[0][i]) j++;
                if (j == 3) return (board[0][i] == 'X') ? "A" : "B";
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ') { 
                int j = 0;
                while (j < 3 && board[i][j] == board[i][0]) j++;
                if (j == 3) return (board[i][0] == 'X') ? "A" : "B";
            }
        }

        if (n != 9) return "Pending";
        return "Draw";
    }
};
