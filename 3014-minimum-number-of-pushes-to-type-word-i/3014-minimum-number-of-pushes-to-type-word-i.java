class Solution1 {
    public int minimumPushes(String word) {
        int result = 0;
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int assignkey = 2;
        for(int i = 0; i<word.length(); i++){
            if(assignkey > 9)assignkey = 2;
            
            map.put(assignkey , map.getOrDefault(assignkey , 0)+1);
            result += map.get(assignkey);
            assignkey++;
        }
        return result;
    }
}

class Solution {
     public int minimumPushes(String word) {
         int result = 0;
         int[] freq = new int[26];
         
         for(int i = 0; i<word.length(); i++){
             char c = word.charAt(i);
             freq[c-'a']++;
         }
         
         Arrays.sort(freq);
         reverse(freq);

         for(int i = 0; i<26; i++){
             int time = freq[i];
             
             int press = i/8 + 1;
             
             int total = press * time;
             result += total;
         }
         return result;
     }
    private static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            // Swap elements
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            left++;
            right--;
        }
    }
}