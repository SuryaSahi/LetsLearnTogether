import java.util.*;
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int n = nums.length;
        for(int i = 0; i<n; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
        }
        
        Integer []temp = new Integer[n];
        for(int i = 0; i<n; i++){
            temp[i] = nums[i];
        }
        
        Arrays.sort(temp , (a,b)->{
            if(map.get(a).equals(map.get(b)))return Integer.compare(b,a);
           
            return Integer.compare(map.get(a) , map.get(b)); 
         });
        
        
        for(int i = 0; i<n; i++){
            nums[i] = temp[i];
        }
        
        return nums;
    }
}