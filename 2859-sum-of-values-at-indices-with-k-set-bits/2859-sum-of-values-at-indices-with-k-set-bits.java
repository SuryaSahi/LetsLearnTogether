class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        List<Integer> res = new ArrayList<>();
        int result = 0;
        for(int i = 0; i<nums.size(); i++){
            String bin = Integer.toBinaryString(i);
            int t = Integer.parseInt(bin);
            int ans = 0;
            while(t > 0){
                ans += t % 10;
                t = t/10;
            }
            if(ans == k)result += nums.get(i);
        }
        return result;
    }
}