//TLE in only recursive solution
class Solution1 {
    int n ;
    int width ;
    public int solve(int[][] books , int index , int rwidth , int maxht){
        if(index >= n)return maxht;
        
        int curr_width = books[index][0];
        int curr_ht = books[index][1];
        
        int keep = Integer.MAX_VALUE;
        int nextshelf = Integer.MAX_VALUE;
        
        if(curr_width <= rwidth)keep = solve(books , index + 1 , rwidth - curr_width , Math.max(maxht , curr_ht));
        
        nextshelf = maxht + solve(books , index + 1 , width - curr_width , curr_ht);
        
        return Math.min(keep , nextshelf);
    }
    
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        width = shelfWidth; // making it global so i can check in different shelfes
        return solve(books , 0,shelfWidth , 0);
    }
}

//using memoization
class Solution {
    int n ;
    int width ;
    int [][]track;
    public int solve(int[][] books , int index , int rwidth , int maxht){
        if(index >= n)return maxht;
        
        if(track[index][rwidth] != -1)return track[index][rwidth];
        
        int curr_width = books[index][0];
        int curr_ht = books[index][1];
        
        int keep = Integer.MAX_VALUE;
        int nextshelf = Integer.MAX_VALUE;
        
        if(curr_width <= rwidth)keep = solve(books , index + 1 , rwidth - curr_width , Math.max(maxht , curr_ht));
        
        nextshelf = maxht + solve(books , index + 1 , width - curr_width , curr_ht);
        
        track[index][rwidth] = Math.min(keep , nextshelf);
        return track[index][rwidth];
    }
    
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        n = books.length;
        track = new int[n][shelfWidth + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= shelfWidth; j++) {
                track[i][j] = -1;
            }
        }
        width = shelfWidth; // making it global so i can check in different shelfes
        return solve(books , 0,shelfWidth , 0);
    }
}

