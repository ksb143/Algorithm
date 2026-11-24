class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int gcd = euclid(denom1, denom2);
        int lcm = denom1 * denom2 / gcd;
        int numer = numer1 * (lcm / denom1) + numer2 * (lcm / denom2);
        
        int lastGcd = euclid(numer, lcm);
         
        int[] answer = {numer / lastGcd, lcm / lastGcd};
        return answer;
    }
    
    public int euclid(int x, int y) {
        while (y != 0) {
            int z = x % y;
            x = y;
            y = z;
        }
        return x;
    }
}