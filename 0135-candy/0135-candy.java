class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies , 1);
        //twice traversal left to right & right to left
        for(int i = 1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        int n = ratings.length;
        //reverse traversal
        for(int i = n - 2; i>= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i] , candies[i+1] + 1);
            }
        }
        int result = 0;
        for(int candy : candies)result += candy;
        
        return result;
    }
}



class Solution2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        // System.out.println(n);
        int[] candies = new int[n];
        Arrays.fill(candies , 1);
        int curr_candies = n;
        for(int i = 1; i<n; i++)
        {
           if(ratings[i] > ratings[i-1])
           {
              candies[i] = candies[i-1] + 1;
           }
        }
        for(int i = n-2; i>=0; i--)
        {
          if(ratings[i] > ratings[i+1])
          {
            candies[i] = Math.max(candies[i] , candies[i+1] + 1);
          }
        }
        int total_candies = 0;
        for(int candy : candies){
          total_candies += candy;
        }
          return total_candies;
    }
}