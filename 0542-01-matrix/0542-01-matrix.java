import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    q.add(new Node(i,j,0));
                }
                else{
                    vis[i][j] = false;
                }
            }
        }
        
        int[] dx = {-1 , 0 , +1 , 0};
        int[] dy = {0 , +1 , 0 , -1};
        while(!q.isEmpty()){
            int x = q.peek().first;
            int y = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[x][y] = steps;
            for(int i = 0; i<4; i++){
                int nrow = x + dx[i];
                int ncol = y + dy[i];
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == false)
                {
                    vis[nrow][ncol] = true;
                    q.add(new Node(nrow , ncol , steps+1));
                }
            }
        }
        return dist;
    }
}
class Node {
    int first;
    int second;
    int third; 
    Node(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}