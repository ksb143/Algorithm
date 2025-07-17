import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[][] countChecks = new int[progresses.length][2];
        for (int i = 0; i < progresses.length; i++) {
            int endCnt;
            if ((100 - progresses[i]) % speeds[i] == 0) {
                endCnt = (100 - progresses[i]) / speeds[i];
            } else {
                endCnt = (100 - progresses[i]) / speeds[i] + 1;
            }
            countChecks[i][0] = i;  // 순서
            countChecks[i][1] = endCnt;  // 순서
        }

        List<Integer> list = new ArrayList<>();
        int minDay = countChecks[0][1];
        int cnt = 0;
        for (int[] cntCheck : countChecks) {
            int idx = cntCheck[0];
            int day = cntCheck[1];
            if (day <= minDay) {
                cnt++;  // 카운트 늘리기
            } else {
                list.add(cnt);  // cnt 삽입
                cnt = 1;  // 카운트 초기화
                minDay = day;  // 최소 기간 교체
            }
        }
        list.add(cnt);  // 마지막 남은 카운트 넣기
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}