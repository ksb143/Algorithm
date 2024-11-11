class Solution {
    private boolean canSolvePuzzles(int[] diffs, int[] times, long limit, int level, int puzzleNum) {
        int[] wrongCounts = new int[puzzleNum]; // 틀릴 개수 배열
        for (int i = 0; i < puzzleNum; i++) {
            wrongCounts[i] = diffs[i] - level >= 0 ? diffs[i] - level : 0;
        }
        long usedTime = times[0] * (wrongCounts[0] + 1);  // 쓴 시간 판단
        for (int i = 1; i < puzzleNum; i++) {
            usedTime += (times[i] + times[i-1]) * (wrongCounts[i]) + times[i];
        }
        boolean result = usedTime > limit ? false : true;
        return result;
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int puzzleNum = diffs.length;  // 퍼즐 개수
        int left = 1;
        int right = 100000;
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canSolvePuzzles(diffs, times, limit, mid, puzzleNum)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}