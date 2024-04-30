class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> container = new HashSet<>();
        for(int[] num : ranges){
            for(int i = num[0]; i<= num[1]; i++){
                container.add(i);
            }
        }
        
        for(int i = left; i<= right; i++){
            if(!container.contains(i))return false;
        }
        return true;
    }
}