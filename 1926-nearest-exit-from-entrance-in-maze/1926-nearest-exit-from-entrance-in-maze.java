class Solution {
    int[][] directions = {{0,1} , {0,-1} , {1, 0} , {-1 , 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        //using BFS
        int n = maze.length;
        int m = maze[0].length;
        
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(entrance[0] , entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        
        while(!que.isEmpty()){
            int size = que.size();
            
            for(int k = 0; k<size; k++){
                Pair p = que.poll();
                
                int u = p.first;
                int v = p.second;
                
                //exit conditions
                if(u != entrance[0] || v != entrance[1]){
                    if(u == 0 || u == n - 1 || v == 0 || v == m - 1)
                        return steps;
                }
                
                //move in directions
                for(int i = 0; i<4; i++){
                    int new_row = u + directions[i][0];
                    int new_col = v + directions[i][1];
                    
                    if(new_row >= 0 && new_row < n && new_col >= 0 && new_col < m && maze[new_row][new_col] != '+'){
                        que.add(new Pair(new_row , new_col));
                        maze[new_row][new_col] = '+';
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}


class Pair{
    int first;
    int second;
    Pair(int first , int second){
        this.first  = first;
        this.second = second;
    }
}