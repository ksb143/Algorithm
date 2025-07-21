class Solution {
    private long countOnes (int n, long l, long r, long start, long end) {
        if (r < start || end < l) {
            return 0;
        }
        // 0단계면 무조건 한개
        if (n == 0) {
            return 1;
        }

        long len = (end - start + 1) / 5;
        long cnt = 0;

        for (int i = 0; i < 5; i++) {
            long ns = start + i * len;
            long ne = ns + len - 1;
            // 2번째는 0이니 넘어가기
            if (i == 2) {
                continue;
            }
            cnt += countOnes(n - 1, l, r, ns, ne);
        }
        return cnt;

    }

    public int solution(int n, long l, long r) {
        return (int) countOnes(n, l, r, 1, (long)Math.pow(5, n));
    }
}