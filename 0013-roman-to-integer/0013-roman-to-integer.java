import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        HashMap<Character, Integer> roman = new HashMap<>();
        
        // Mapping Roman numerals to their integer values
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        // Loop through the string and calculate the integer value
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (roman.get(a) < roman.get(b)) {
                ans -= roman.get(a);
            } else {
                ans += roman.get(a);
            }
        }

        // Add the value of the last character
        ans += roman.get(s.charAt(s.length() - 1));
        return ans;
    }
}
