class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i<10; i++){
            int temp = i;
            int k = i+1;
            while(temp <= high && k <= 10){
                if(temp >= low)ans.add(temp);
                temp = temp * 10 + k++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}