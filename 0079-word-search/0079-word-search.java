class Solution {
    public boolean exist(char[][] board, String word) {
        //using backtracking approach
        int n = board.length;
        int m = board[0].length;
        
        int index = 0;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == word.charAt(index))
                if(helper(board , word , i , j , m , n , 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board ,String word, int curr_row , int curr_col , int m , int n , int index ){
        {
         if(index == word.length())return true;
            
            if(curr_row < 0 || curr_col < 0 || curr_row == n || curr_col == m || word.charAt(index) != board[curr_row][curr_col] || board[curr_row][curr_col] == '!') return false;
            
          //to protect no repetition of character
            char c = board[curr_row][curr_col];
            board[curr_row][curr_col] = '!';
            
            boolean top = helper(board , word , curr_row - 1 , curr_col, m , n , index + 1);
            boolean bottom = helper(board , word , curr_row + 1, curr_col, m , n , index + 1);
            boolean left  = helper(board , word , curr_row, curr_col - 1 , m , n , index + 1);
            boolean right = helper(board , word , curr_row , curr_col + 1 , m , n , index + 1);
            
            //returning values for backtracking
            board[curr_row][curr_col] = c;
            
            return top || bottom || left || right;
        }
    }
}