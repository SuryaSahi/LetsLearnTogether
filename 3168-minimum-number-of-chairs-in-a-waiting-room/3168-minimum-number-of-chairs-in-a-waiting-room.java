class Solution {
    public int minimumChairs(String s) {
        int max_chair = Integer.MIN_VALUE;
        int chair = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'E'){
                chair++;
                max_chair = Math.max(max_chair , chair);
            }
            else{
                chair--;
            }
        }
        return max_chair;
    }
}