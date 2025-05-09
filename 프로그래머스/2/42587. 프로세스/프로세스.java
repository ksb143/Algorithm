import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        int[] priCnt = new int[10];
        int maxVal = 0;
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[] {priorities[i], i});
            priCnt[priorities[i]] += 1;
        }
        int idx = 9;
        int count = 0;
        int answer = 0;
        while (!q.isEmpty()) {
            while (priCnt[idx] == 0) {
                idx -= 1;
            }
            int[] vals = q.poll();
            if (vals[0] != idx) {
                q.offer(vals);  // 해당 값이 우선순위가 아니면 다시 집어넣기
            } else {
                count++;
                if (vals[1] == location) {
                    answer = count;
                    break;
                }
                priCnt[idx] -= 1;
            }
        }
        return answer;
    }
}