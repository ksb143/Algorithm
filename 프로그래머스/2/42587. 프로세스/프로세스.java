import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 큐를 만들고 우선순위, index를 큐에 넣기
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }
        int cnt = 0;
        int answer = 0;
        while (!queue.isEmpty()) {
            // 우선순위를 반복문을 돌면서 더 높은 것이 있는지 확인
            int[] check = queue.poll();
            boolean flag = true;
            for (int[] rest : queue) {
                if (rest[0] > check[0]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {  // 우선순위가 반복문 돌면서 더 높은 것이 없다면
                cnt += 1;
                if (check[1] == location) {
                    answer = cnt;
                    break;
                }
            } else {  // 우선순위가 반복문 돌면서 더 높은 것이 있다면
                queue.offer(check);
            }
        }
        return answer;
    }
}