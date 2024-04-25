class Solution {
    public void dfs(char[][] board, int[][] vis, int[] dx, int[] dy, int a, int b) {
        vis[a][b] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = a + dx[i];
            int ncol = b + dy[i];
            
            if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0)
                dfs(board, vis, dx, dy, nrow, ncol);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        
        int[] dx = {0 , 0 , 1 , -1};
        int[] dy = {-1 , 1 , 0, 0 };
        
        // //now checking for '0' in boundary
        // for(int i = 0; i<m; i++){
        //     // in first row
        //     if(board[0][i] == 'O' && vis[0][i] == 0)dfs(board , vis , dx , dy , 0 , i);
        //     //bottom row
        //     if(board[n-1][i] == 'O' && vis[n-1][i] == 0)dfs(board , vis , dx , dy , n-1 , i);
        //     //left column boundry
        //     if(board[i][0] == 'O' && vis[i][0] == 0)dfs(board , vis , dx , dy , i , 0);
        //     //right column boundry
        //     if(board[i][m - 1] == 'O' && vis[i][m - 1] == 0)dfs(board , vis , dx , dy , i , m - 1);
        // }
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         if(board[i][j] == 'O' && vis[i][j] == 1)board[i][j] = 'X';
        //     }
        // }
        // Now checking for 'O' in boundary
        for (int i = 0; i < m; i++) {
            // In first row
            if (board[0][i] == 'O' && vis[0][i] == 0)
                dfs(board, vis, dx, dy, 0, i);
            // Bottom row
            if (board[n - 1][i] == 'O' && vis[n - 1][i] == 0)
                dfs(board, vis, dx, dy, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            // Left column boundary
            if (board[i][0] == 'O' && vis[i][0] == 0)
                dfs(board, vis, dx, dy, i, 0);
            // Right column boundary
            if (board[i][m - 1] == 'O' && vis[i][m - 1] == 0)
                dfs(board, vis, dx, dy, i, m - 1);
        }
        // Replace 'O' with 'X' for 'O' surrounded by 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0)
                    board[i][j] = 'X';
            }
        }
    }
}