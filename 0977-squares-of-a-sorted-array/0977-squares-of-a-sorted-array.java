class Solution {
    public int[] sortedSquares(int[] nums) {
        int start = 0;
        int last = nums.length - 1;
        int[] result = new int[nums.length];
        int checker = nums.length - 1;
        while(start <= last)
        {
            int a = nums[start] * nums[start];
            int b = nums[last] * nums[last];
            if(a < b)
            {
                result[checker--] = b;
                last--;
            }
            else
            {
                result[checker--] = a;
                start++;
            }
        }
        return result;
    }
}