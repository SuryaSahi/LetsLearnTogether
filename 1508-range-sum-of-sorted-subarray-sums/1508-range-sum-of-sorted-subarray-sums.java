class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int sum = 0;  
            for(int j = i; j<nums.length; j++){
                sum += nums[j];
                temp.add(sum);
            }
        }
        Collections.sort(temp);
        int result = 0;
        for(int i = left-1; i<right; i++){
            result += temp.get(i);
            result %= 1000000007;
        }
        return result;
    }
}