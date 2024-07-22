import java.util.*;
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer , String> map = new HashMap<>();
        for(int i = 0; i<names.length; i++){
            map.put(heights[i] , names[i]);
        }
        
        //sort heights in descending order
        Arrays.sort(heights);
        String ans[] = new String[names.length];
        for(int j = 0 , i = names.length - 1; i>=0 && j<names.length; i-- , j++){
            ans[j] = map.get(heights[i]);
        }
        
        return ans;
    }
}