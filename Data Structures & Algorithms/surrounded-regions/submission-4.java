class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) && board[i][j] == 'O')
                    dfs(i,j, board);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'V') 
                    board[i][j] = 'O';
                else if (board[i][j] == 'O') 
                    board[i][j] = 'X';
            }
        }
        
    }

    private void dfs(int x, int y, char[][] board) {
        
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X' || board[x][y] == 'V') 
            return;
        
        board[x][y] = 'V';

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            dfs(nextX, nextY, board);
        }

    }
}
