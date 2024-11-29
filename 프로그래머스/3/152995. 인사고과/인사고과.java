import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n = scores.length;
        int[] wanho = scores[0];
        boolean[] isFails = new boolean[n];
        // 근무 태도 점수 내림차순, 동료 평가 점수 오름차순
        Arrays.sort(scores, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        int maxCoworkerScore = 0;
        boolean isWanhoFail = false;
        // 교차하면서 완호가 탈락 대상인지 찾기
        int idx = 0;
        for (int[] score : scores) {
            if (score[1] < maxCoworkerScore) {
                isFails[idx] = true;
                if (Arrays.equals(score, wanho)) {
                    isWanhoFail = true;
                }
            } else {
                maxCoworkerScore = score[1];
            }
            idx++;
        }
        if (isWanhoFail) {
            return -1;
        }
        // 총점수 비교
        List<Integer> totalScores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isFails[i]) {
                totalScores.add(scores[i][0] + scores[i][1]);
            }
        }
        totalScores.sort(Collections.reverseOrder());
        // 완호 점수 찾기
        int wanhoTotalScore = wanho[0] + wanho[1];
        int rank = 1;
        for (int totalScore : totalScores) {
            if (totalScore > wanhoTotalScore) {
                rank++;
            } else {
                break;
            }
        }

        return rank;
    }
}