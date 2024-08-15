class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            while (!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {
                int n = st.peek();

                if (Math.abs(n) == Math.abs(asteroids[i])) { // Both asteroids destroy each other
                    st.pop();
                    asteroids[i] = 0; // Mark as destroyed
                    break;
                } else if (Math.abs(n) < Math.abs(asteroids[i])) { // Stack asteroid is destroyed
                    st.pop();
                } else { // Current asteroid is destroyed
                    asteroids[i] = 0;
                    break;
                }
            }

            if (asteroids[i] != 0) { // Push if it's not destroyed
                st.push(asteroids[i]);
            }
        }

        int[] temp = new int[st.size()];
        int i = st.size() - 1;
        while (!st.isEmpty()) {
            temp[i] = st.pop();
            i--;
        }

        return temp;
    }
}
