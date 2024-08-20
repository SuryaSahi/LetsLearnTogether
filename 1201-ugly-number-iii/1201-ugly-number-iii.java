//Solution 1 is brute force similar to Ugly Number
class Solution1 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int num = Math.min(a , Math.min(b , c));
        
        while(n > 1){
            n--;
            num++;
            while(!(isUgly(num , a , b ,c)))num++;
        }
        return num;
    }
    public boolean isUgly(int n, int a, int b, int c){
        if(n % a == 0 || n % b == 0 || n % c == 0) return true;
        return false;
    }
    
}

class Solution {
    long a, b, c, ab, bc, ac, abc;

    public long countMultiples(long mid) {
        return (mid / a) + (mid / b) + (mid / c) - (mid / ab) - (mid / bc) - (mid / ac) + (mid / abc);
    }

    public int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

        ab = ((long) a * b) / gcd(a, b);
        bc = ((long) b * c) / gcd(b, c);
        ac = ((long) a * c) / gcd(a, c);
        abc = ((long) a * bc) / gcd(a, (int) bc);

        long left = 0, right = Long.MAX_VALUE;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (countMultiples(mid) < n) left = mid + 1;
            else right = mid - 1;
        }

        return (int) left;
    }
}
