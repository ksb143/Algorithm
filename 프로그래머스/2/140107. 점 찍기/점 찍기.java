class Solution {
    public long solution(int k, int d) {
        long count = 0;
        long dk = (long) d;
        long kk = (long) k;

        for (long x = 0; x * kk <= dk; x++) {
            long xk = x * kk;
            long maxY = (long) Math.sqrt(dk * dk - xk * xk);
            count += (maxY / kk) + 1;
        }



        return count;
    }
}