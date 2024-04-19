import java.util.*;
public class Solution {
    public static int findNumOfProvinces(int[][] roads, int n) {
        // Write your code here.
        int cnt = 0;
        //graph traversal
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(roads[i][j] == 1 && i != j){
                    graph.get(i).add(j);
                }
            }
        }
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                traverse(i,visited,graph);
                cnt++;
            }
        }
        return cnt;
    }
    public static void traverse(int point , boolean[] visited ,ArrayList<ArrayList<Integer>> graph ){
        visited[point] = true;
        for(int i : graph.get(point)){
            if(!visited[i]){
                traverse(i, visited, graph);
            }
        }
    } 
}
