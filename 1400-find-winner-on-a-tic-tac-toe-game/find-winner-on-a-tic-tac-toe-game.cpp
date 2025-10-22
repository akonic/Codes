class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        int n=moves.size();
        vector<vector<char>> board(3,vector<char>(3,' '));
        
        for(int i=0;i<n;i++)
        {   
            int x=moves[i][0],y=moves[i][1];
            if(i%2==0)
            {
                board[x][y]='X';
            }
            else{
                board[x][y]='O';
            }
        }
        
        if(board[0][0]=='X')
        {
            int i=0,j=0;
            while(i<3 && j<3 && board[i][j]=='X' )
            {
                i++;j++;
            }
            if(i==3)
            {
                return "A";
            }
        }
         if(board[0][2]=='O')
        {
            int i=0,j=2;
            while(i<3 && j>=0 && board[i][j]=='O')
            {
                i++;j--;
            }
            if(i==3)
            {
                return "B";
            }
        }
        if(board[0][2]=='X')
        {
            int i=0,j=2;
            while(i<3 && j>=0 && board[i][j]=='X')
            {
                i++;j--;
            }
            if(i==3)
            {
                return "A";
            }
        }
         if(board[0][0]=='O')
        {
            int i=0,j=0;
            while(i<3 && j<3 && board[i][j]=='X' )
            {
                i++;j++;
            }
            if(i==3)
            {
                return "B";
            }
        }
        for(int i=0;i<3;i++)
        {
            if(board[0][i]=='X')
            {
                int j=0;
                while(j<3 && board[j][i]=='X'){
                    j++;
                }
                if(j==3)
                {
                    return "A";
                }

            }
            if(board[0][i]=='O')
            {
                int j=0;
                while(j<3 && board[j][i]=='O'){
                    j++;
                }
                if(j==3)
                {
                    return "B";
                }

            }
        }
        for(int i=0;i<3;i++)
        {
            if(board[i][0]=='X')
            {
                int j=0;
                while(j<3 && board[i][j]=='X'){
                    j++;
                }
                if(j==3)
                {
                    return "A";
                }

            }
            if(board[0][i]=='O')
            {
                int j=0;
                while(j<3 && board[i][j]=='O'){
                    j++;
                }
                if(j==3)
                {
                    return "B";
                }
            }
        }
        if(n!=9)
        {
            return "Pending";
        }
        return "Draw";

    }
};