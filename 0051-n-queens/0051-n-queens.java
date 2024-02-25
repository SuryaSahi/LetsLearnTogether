class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        //putting '.' on places intially
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(0 , board , ans , res , n);
        return ans;
    }
    
    //traversal for placing Queen's
    private void helper(int row , char[][] board ,List<List<String>> ans , List<String> res , int n ){
        if(row == n){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int col = 0; col < n; col++){
            if(isValid(board , row , col , n)){
                board[row][col] = 'Q';
                StringBuilder sb = new StringBuilder();
                for(int i = 0 ; i < n; i++){
                    sb.append(board[row][i]);
                }
                res.add(sb.toString());
                helper(row + 1 , board , ans ,res ,n);
                board[row][col] = '.';
                res.remove(res.size() - 1);
            }
        }
    }
    private boolean isValid(char[][] board , int row , int col , int n ){
        //vertical check
        for(int i = 0; i<row; i++){
            if(board[i][col] == 'Q')return false;
        }
        
        //upper left diagonal
        for(int i = row - 1 , j = col - 1; i >= 0 && j >= 0; i-- , j--){
            if(board[i][j] == 'Q')return false;
        }
        
        //upper right diagonal
        for(int i = row - 1 , j = col + 1; i >= 0 && j < n; i--,j++){
            if(board[i][j] == 'Q')return false;
        }
        return true;
    }
}