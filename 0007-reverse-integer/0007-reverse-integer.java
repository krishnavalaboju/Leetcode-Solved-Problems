class Solution {
    public int reverse(int x) {
        int a = x, b = 0, c = 0, d = 0; 
        while (a != 0) { 
            b = a % 10; 
            if (c > Integer.MAX_VALUE / 10 || (c == Integer.MAX_VALUE / 10 && b > 7)) {
                return 0;
            }
            if (c < Integer.MIN_VALUE / 10 || (c == Integer.MIN_VALUE / 10 && b < -8)) {
                return 0;
            }
            
            c = c * 10 + b; 
            a /= 10; 
        } 
        return c; 
    } 
}